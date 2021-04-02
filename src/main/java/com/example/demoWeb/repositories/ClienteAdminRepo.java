package com.example.demoWeb.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demoWeb.models.ClienteAdminModel;

@Repository
public interface ClienteAdminRepo extends CrudRepository<ClienteAdminModel, Long>{

	public abstract ArrayList<ClienteAdminModel> findByEmail(String email) ;
}
