package com.jofre.uapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jofre.uapp.domain.Evento;
import com.jofre.uapp.services.EventoService;

@RestController
@RequestMapping(value="/eventos")
public class EventoResource {
	
	@Autowired
	private EventoService service; 
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Evento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
