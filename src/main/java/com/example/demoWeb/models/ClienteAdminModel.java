package com.example.demoWeb.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente_admin")
public class ClienteAdminModel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
	
	private String email;
	private String pwd;
	private String phone;
	private int status;	
	private Date created_at;
	private Date altered_at;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getAltered_at() {
		return altered_at;
	}
	public void setAltered_at(Date altered_at) {
		this.altered_at = altered_at;
	}
}
