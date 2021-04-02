package com.example.demoWeb.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoWeb.models.ClienteAdminModel;
import com.example.demoWeb.services.ClienteAdminSrv;

@RestController
@RequestMapping("/cliente")
public class ClienteAdminCtrl {

	@Autowired
	ClienteAdminSrv clienteService;
	
	
	@GetMapping("/getAll")
	public ArrayList<ClienteAdminModel> getAll(){
		return clienteService.getClientes();
	}
	
	@PostMapping("/saveCliente")
	public ClienteAdminModel saveCliente(@RequestBody ClienteAdminModel newCliente) {
		return clienteService.saveCliente(newCliente); 
	}
	
	@PostMapping("/findCliente")
	public ArrayList<ClienteAdminModel> findClienteByEmail(@RequestParam("email") String email){
		return clienteService.getByEmail(email);
	}
}
