package com.jofre.uapp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jofre.uapp.domain.Evento;
import com.jofre.uapp.dto.EventoDTO;
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
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Evento obj){			// A anotation @RequestBody converte p Jsom em objeto
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()		//fornece uma URI com id já gravado no
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		// banco de dados
		
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Evento obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);	
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Evento> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<EventoDTO>> findAll(){
		List<Evento> list = service.findAll();
		List<EventoDTO>listDTO = list.stream().map(obj ->new EventoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<EventoDTO>> findPage(
			@RequestParam(value ="page", defaultValue = "0")Integer page, 
			@RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value ="orderBy", defaultValue = "observacao")String orderBy, 
			@RequestParam(value ="direction", defaultValue = "ASC")String direction){
		Page<Evento> list = service.findPage(page,linesPerPage, orderBy, direction);
		Page<EventoDTO>listDTO = list.map(obj ->new EventoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

}
