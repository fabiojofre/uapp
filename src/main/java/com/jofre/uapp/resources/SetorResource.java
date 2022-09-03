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

import com.jofre.uapp.domain.Setor;
import com.jofre.uapp.dto.SetorDTO;
import com.jofre.uapp.services.SetorService;



@RestController
@RequestMapping(value="/setores")
public class SetorResource {
	
	@Autowired
	private SetorService service; 
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Setor> find(@PathVariable Integer id){
		Setor obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SetorDTO objDTO){			// A anotation @RequestBody converte p Jsom em objeto
		Setor obj = service.FromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()		//fornece uma URI com id já gravado no
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		// banco de dados
		
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody SetorDTO objDTO, @PathVariable Integer id){
		Setor obj = service.FromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);	
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Setor> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<SetorDTO>> findAll(){
		List<Setor> list = service.findAll();
		List<SetorDTO>listDTO = list.stream().map(obj ->new SetorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	//retornar lista por paginação no endpoit
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<SetorDTO>> findPage(
			@RequestParam(value ="page", defaultValue = "0")Integer page, 
			@RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value ="orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value ="direction", defaultValue = "ASC")String direction){
		Page<Setor> list = service.findPage(page,linesPerPage, orderBy, direction);
		Page<SetorDTO>listDTO = list.map(obj ->new SetorDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}
