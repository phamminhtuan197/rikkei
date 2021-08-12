//package com.rikkei.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name = "app_roles")
//public class AppRole implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long roleId;
//	
//	private String name;
//
//	public Long getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(Long roleId) {
//		this.roleId = roleId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public AppRole(Long roleId, String name) {
//		super();
//		this.roleId = roleId;
//		this.name = name;
//	}
//
//	public AppRole() {
//		super();
//	}
//	
//}
