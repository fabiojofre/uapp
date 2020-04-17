package com.jofre.uapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jofre.uapp.domain.TipoEvento;
import com.jofre.uapp.services.TipoEventoService;

@RestController
@RequestMapping(value = "/tipoeventos")
public class TipoEventoResource {

	@Autowired
	private TipoEventoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		TipoEvento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
