package com.towasoftware.springmvcexample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "user")
@Table(name = "usuario")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	private String name;

	@Column(name = "apellido")
	private String lastname;

	@Column(name = "direccion")
	private String address;

	@JoinColumn(name = "idRol", referencedColumnName = "id")
    @ManyToOne
	private Rol rol;

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User(Integer id, String name, String lastname, String address, Rol rol) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.rol = rol;
	}

	public User(Integer id, String name, String lastname, String address) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.address = address;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [id= " + id + ", name=" + name + ", lastname=" + lastname + ", address=" + address + "]";
	}

}
