package com.jofre.uapp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jofre.uapp.domain.TipoEvento;
import com.jofre.uapp.dto.TipoEventoDTO;
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
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TipoEventoDTO objDTO){			// A anotation @RequestBody converte p Jsom em objeto
		TipoEvento obj = service.FromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()		//fornece uma URI com id já gravado no
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		// banco de dados
		
		return ResponseEntity.created(uri).build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody TipoEventoDTO objDTO, @PathVariable Integer id){
		TipoEvento obj = service.FromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);	
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TipoEvento> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<TipoEventoDTO>> findAll(){
		List<TipoEvento> list = service.findAll();
		List<TipoEventoDTO>listDTO = list.stream().map(obj ->new TipoEventoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	//retornar lista por paginação no endpoit
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<TipoEventoDTO>> findPage(
			@RequestParam(value ="page", defaultValue = "0")Integer page, 
			@RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value ="orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value ="direction", defaultValue = "ASC")String direction){
		Page<TipoEvento> list = service.findPage(page,linesPerPage, orderBy, direction);
		Page<TipoEventoDTO>listDTO = list.map(obj ->new TipoEventoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}


}
