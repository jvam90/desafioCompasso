package com.jvam90.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jvam90.desafio.entidades.Cliente;
import com.jvam90.desafio.services.ClienteService;

@RestController
@RequestMapping(value ="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listarPorNome(@PathVariable String nome) {
		List<Cliente> clientes = clienteService.buscarPorNome(nome);
		return ResponseEntity.ok(clientes);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> listarPorId(@PathVariable Integer id) {
		Cliente cliente = clienteService.buscarPorId(id);
		return ResponseEntity.ok(cliente);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
		Cliente obj = clienteService.cadastrar(cliente);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Object> remover(@PathVariable Integer id) {
		clienteService.remover(id);
		return ResponseEntity.ok(null);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente) {
		Cliente obj = clienteService.alterar(cliente);
		return ResponseEntity.ok(obj);
	}

}
