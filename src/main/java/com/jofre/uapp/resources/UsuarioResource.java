package com.jofre.uapp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.jofre.uapp.domain.Usuario;
import com.jofre.uapp.dto.UsuarioDTO;
import com.jofre.uapp.dto.UsuarioNewDTO;
import com.jofre.uapp.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id){
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNewDTO objDTO){			// A anotation @RequestBody converte p Jsom em objeto
		Usuario obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()		//fornece uma URI com id já gravado no
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		// banco de dados
		
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO objDTO, @PathVariable Integer id){
		Usuario obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);	
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<Usuario> list = service.findAll();
		List<UsuarioDTO>listDTO = list.stream().map(obj ->new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	//retornar lista por paginação no endpoit
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<UsuarioDTO>> findPage(
			@RequestParam(value ="page", defaultValue = "0")Integer page, 
			@RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value ="orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value ="direction", defaultValue = "ASC")String direction){
		Page<Usuario> list = service.findPage(page,linesPerPage, orderBy, direction);
		Page<UsuarioDTO>listDTO = list.map(obj ->new UsuarioDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}
