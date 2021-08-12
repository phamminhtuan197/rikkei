//package com.rikkei.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@SuppressWarnings("serial")
//
//@Entity
//@Table(name = "user_roles")
//public class UserRole implements Serializable{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@ManyToOne()
//	@JoinColumn(name = "user_id")
//	private User user;
//	
//	@ManyToOne()
//	@JoinColumn(name = "role_id")
//	private AppRole roles;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public AppRole getRoles() {
//		return roles;
//	}
//
//	public void setRoles(AppRole roles) {
//		this.roles = roles;
//	}
//
//	public UserRole(Long id, User user, AppRole roles) {
//		super();
//		this.id = id;
//		this.user = user;
//		this.roles = roles;
//	}
//
//	public UserRole() {
//		super();
//	}
//	
//}
