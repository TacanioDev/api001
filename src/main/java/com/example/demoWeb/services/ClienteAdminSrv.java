package com.example.demoWeb.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoWeb.models.ClienteAdminModel;
import com.example.demoWeb.repositories.ClienteAdminRepo;
import com.example.demoWeb.util.ApiConstants;
import com.example.demoWeb.util.SecurityUtil;

@Service
public class ClienteAdminSrv {

	@Autowired
	ClienteAdminRepo cliente;
	
	public ArrayList<ClienteAdminModel> getClientes(){
		return  (ArrayList<ClienteAdminModel>) cliente.findAll();
	}
	
	public ClienteAdminModel saveCliente(ClienteAdminModel newCliente) {
		ArrayList<ClienteAdminModel> existe = cliente.findByEmail(newCliente.getEmail());
		
		if(existe!=null && existe.size()>0) {
			return existe .get(0);
		}else {
			newCliente.setCreated_at(new Date(System.currentTimeMillis()));
			newCliente.setAltered_at(newCliente.getCreated_at());
			newCliente.setStatus(1);
			//convert to PassWordSecure pws
			String pws =SecurityUtil.encrypt(newCliente.getPwd(), ApiConstants.KEY);
			newCliente.setPwd(pws);
			return cliente.save(newCliente);
		}			
	}
	
	public ArrayList<ClienteAdminModel> getByEmail(String email) {
		return cliente.findByEmail(email);
	}
	
	public Optional<ClienteAdminModel> getById(long id){
		return cliente.findById(id);
	}
	
	public boolean delClienteAdmin(Long id) {
		try {
			cliente.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
