package com.gustavo.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="User")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer idUser;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRole",nullable=false)
	private Role idRol;
	@Column(name = "uuid", nullable = false, length = 50)
	private String uuid;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "firstName", nullable = false, length = 255)
	private String firstName;
	
	@Column(name = "lastName", nullable = false, length = 255)
	private String lastName;
	
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	@Column(name = "creationDate", nullable = false, length = 255)
	private Date creationDate;

}
