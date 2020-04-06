package com.jofre.uapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jofre.uapp.domain.TipoPessoa;
import com.jofre.uapp.services.TipoPessoaService;

@RestController
@RequestMapping(value = "/tipopessoas")
public class TipoPessoaResource {

	@Autowired
	private TipoPessoaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TipoPessoa> find(@PathVariable Integer id) {
		TipoPessoa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
