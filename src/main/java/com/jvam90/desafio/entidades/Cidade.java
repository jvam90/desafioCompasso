package com.jvam90.desafio.entidades;

import java.io.Serializable;

public class Cidade implements Serializable {
	
	private static final long serialVersionUID = 8653970141174181222L;
	private String nome;
	private String estado;
	
	public Cidade() {
		
	}
	
	public Cidade(String nome, String estado) {
		this.nome = nome;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
