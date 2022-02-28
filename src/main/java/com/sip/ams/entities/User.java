package com.sip.ams.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="user")
public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="user_id")	
 private int id;

@NotEmpty(message = "*please provide an Email")
@Email(message = "*Please provide a valid Email")
@Column(name="email")
 private String email;

@NotEmpty(message = "*Please provide a password")
@Length(min = 5,message = "*Your password must have at least 5 characters")
@Column(name="password")
 private String password;

@NotEmpty(message = "*Please provide your name")
@Column(name="name")
 private String name;
 
@NotEmpty(message = "*Please provide your last name")
@Column(name="last_name")
private String last_name;
 
 
@Column(name="active")
 private int active;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "user_role" , joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
private Set<Role> roles;

public User(int id,
		@NotEmpty(message = "*please provide an Email") @Email(message = "*Please provide a valid Email") String email,
		@NotEmpty(message = "*Please provide a password") @Length(min = 5, message = "*Your password must have at least 5 characters") String password,
		@NotEmpty(message = "*Please provide your name") String name,
		@NotEmpty(message = "*Please provide your last name") String last_name, int active, Set<Role> roles) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.name = name;
	this.last_name = last_name;
	this.active = active;
	this.roles = roles;
}



public User(int id,
		@NotEmpty(message = "*please provide an Email") @Email(message = "*Please provide a valid Email") String email,
		@NotEmpty(message = "*Please provide a password") @Length(min = 5, message = "*Your password must have at least 5 characters") String password,
		@NotEmpty(message = "*Please provide your name") String name,
		@NotEmpty(message = "*Please provide your last name") String last_name, int active) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.name = name;
	this.last_name = last_name;
	this.active = active;
}



public User() {
	super();
	// TODO Auto-generated constructor stub
}



public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getLast_name() {
	return last_name;
}


public void setLast_name(String last_name) {
	this.last_name = last_name;
}


public int getActive() {
	return active;
}


public void setActive(int active) {
	this.active = active;
}



public Set<Role> getRoles() {
	return roles;
}



public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
 

}
