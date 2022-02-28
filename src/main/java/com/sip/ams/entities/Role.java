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

}
