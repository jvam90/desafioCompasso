package com.jvam90.desafio.entidades;

import java.io.Serializable;

public class Cliente implements Serializable{

	private static final long serialVersionUID = -9148095834550183273L;
	public Integer id;
	public String nome;
	
	public Cliente() {
		
	}

	public Cliente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
