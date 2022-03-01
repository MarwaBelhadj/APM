package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "role_id")
private int id;

@NotEmpty(message = "*Please provide new role")
@Column(name = "role")
private String role;

public Role(int id, @NotEmpty(message = "*Please provide new role") String role) {
	super();
	this.id = id;
	this.role = role;
}

public Role(@NotEmpty(message = "*Please provide new role") String role) {
	super();
	this.role = role;
}

public Role() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}


}
