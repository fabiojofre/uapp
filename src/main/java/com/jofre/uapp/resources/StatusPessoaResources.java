package com.jofre.uapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jofre.uapp.domain.Spessoa;
import com.jofre.uapp.services.StatusPessoaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/statuspessoa")
public class StatusPessoaResources {
	@Autowired
	private StatusPessoaService service; 
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		
		Spessoa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
