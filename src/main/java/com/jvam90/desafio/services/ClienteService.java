package com.jvam90.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jvam90.desafio.entidades.Cliente;
import com.jvam90.desafio.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> buscarPorNome(String nome) {
		Cliente param = new Cliente();
		param.setNome(nome.toUpperCase());
		Example<Cliente> clienteExample = Example.of(param);
		List<Cliente> clientes = repository.findAll(clienteExample);
		return clientes;
	}
	
	public Cliente buscarPorId(Integer id) {
		Cliente cli = repository.findById(id).get();
		return cli;
	}
	
	public Cliente cadastrar(Cliente cliente) {
		cliente.setNome(cliente.getNome().toUpperCase());
		return repository.save(cliente);
	}
	
	public void remover(Integer id) {
		Cliente cli = repository.findById(id).get(); 
		repository.delete(cli);
	}
	
	public Cliente alterar(Cliente cliente) {
		Cliente cli = repository.findById(cliente.getId()).get();
		if(cli != null) {
			cli.setNome(cliente.getNome().toUpperCase());
			cli.setCidade(cliente.getCidade());
			cli.setDataNascimento(cliente.getDataNascimento());
			cli.setIdade(cliente.getId());
			cli.setSexo(cliente.getSexo());	
			repository.save(cli);
		}
		return cli;
		
		
	}
}
