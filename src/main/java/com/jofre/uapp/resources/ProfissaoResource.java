package com.jofre.uapp.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jofre.uapp.domain.Profissao;
import com.jofre.uapp.services.ProfissaoService;

@RestController
@RequestMapping(value="/proficoes")
public class ProfissaoResource {
	
	@Autowired
	private ProfissaoService service; 
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Profissao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Profissao obj){			// A anotation @RequestBody converte p Jsom em objeto
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()		//fornece uma URI com id já gravado no
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		// banco de dados
		
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Profissao obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);	
		return ResponseEntity.noContent().build();
	}

}
