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

import com.jofre.uapp.domain.Servico;
import com.jofre.uapp.dto.ServicoDTO;
import com.jofre.uapp.dto.ServicoNewDTO;
import com.jofre.uapp.services.ServicoService;

@RestController
@RequestMapping(value="/servicos")
public class ServicoResource {
	
	@Autowired
	private ServicoService service; 
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Servico> find(@PathVariable Integer id) {
		Servico obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid  @RequestBody ServicoNewDTO objDTO){			// A anotation @RequestBody converte p Jsom em objeto
		Servico obj = service.fromDTO(objDTO);
			obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()		//fornece uma URI com id já gravado no
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		// banco de dados
		
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ServicoDTO objDTO, @PathVariable Integer id){
		Servico obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);	
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Servico> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<ServicoDTO>> findAll(){
		List<Servico> list = service.findAll();
		List<ServicoDTO>listDTO = list.stream().map(obj ->new ServicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ServicoDTO>> findPage(
			@RequestParam(value ="page", defaultValue = "0")Integer page, 
			@RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value ="orderBy", defaultValue = "observacao")String orderBy, 
			@RequestParam(value ="direction", defaultValue = "ASC")String direction){
		Page<Servico> list = service.findPage(page,linesPerPage, orderBy, direction);
		Page<ServicoDTO>listDTO = list.map(obj ->new ServicoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

}
