package com.jofre.uapp.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jofre.uapp.domain.FrequenciaEvento;
import com.jofre.uapp.dto.FrequenciaEventoDTO;
import com.jofre.uapp.services.FrequenciaEventoService;



@RestController
@RequestMapping(value="/frequenciaeventos")
public class FrequenciaEventoResource {
	
	@Autowired
	private FrequenciaEventoService service; 
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FrequenciaEventoDTO objDTO){			// A anotation @RequestBody converte p Jsom em objeto
		FrequenciaEvento obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()		//fornece uma URI com id já gravado no
				.path("/{id}").buildAndExpand(obj.getEvento().getId()).toUri();		// banco de dados
		return ResponseEntity.created(uri).build();
	}


}
