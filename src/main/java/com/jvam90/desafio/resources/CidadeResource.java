package com.jvam90.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jvam90.desafio.entidades.Cidade;
import com.jvam90.desafio.services.CidadeService;

@RestController
@RequestMapping(value ="/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> listarPorNome(@PathVariable String nome) {
		List<Cidade> cidades = cidadeService.buscarPorNome(nome);
		return ResponseEntity.ok(cidades);
	}
	
	@RequestMapping(value = "/estado/{estado}", method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> listarPorEstado(@PathVariable String estado) {
		List<Cidade> cidades = cidadeService.buscarPorEstado(estado);
		return ResponseEntity.ok(cidades);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cidade> cadastrar(@RequestBody Cidade cidade) {
		Cidade obj = cidadeService.cadastrar(cidade);
		return ResponseEntity.ok(obj);
	}

}
