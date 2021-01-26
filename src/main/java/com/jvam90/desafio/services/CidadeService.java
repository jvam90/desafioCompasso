package com.jvam90.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jvam90.desafio.entidades.Cidade;
import com.jvam90.desafio.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> buscarPorNome(String nome) {
		Cidade param = new Cidade();
		param.setNome(nome.toUpperCase());
		Example<Cidade> cidadeExample = Example.of(param);
		List<Cidade> cidades = repository.findAll(cidadeExample);
		return cidades;
	}
	
	public List<Cidade> buscarPorEstado(String estado) {
		Cidade param = new Cidade();
		param.setEstado(estado.toUpperCase());
		Example<Cidade> cidadeExample = Example.of(param);
		List<Cidade> cidades = repository.findAll(cidadeExample);
		return cidades;
	}
	
	public Cidade cadastrar(Cidade cidade) {
		cidade.setNome(cidade.getNome().toUpperCase());
		cidade.setEstado(cidade.getEstado().toUpperCase());
		return repository.save(cidade);
	}
}
