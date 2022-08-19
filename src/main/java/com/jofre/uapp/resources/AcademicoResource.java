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

import com.jofre.uapp.domain.Academico;
import com.jofre.uapp.dto.AcademicoDTO;
import com.jofre.uapp.dto.AcademicoNewDTO;
import com.jofre.uapp.services.AcademicoService;

@RestController
@RequestMapping(value="/academicos")
public class AcademicoResource {
	
	@Autowired
	private AcademicoService service; 
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Academico> find(@PathVariable Integer id){
		Academico obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AcademicoNewDTO objDTO){			// A anotation @RequestBody converte p Jsom em objeto
		Academico obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()		//fornece uma URI com id já gravado no
				.path("/{id}").buildAndExpand(obj.getId()).toUri();		// banco de dados
		
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody AcademicoDTO objDTO, @PathVariable Integer id){
		Academico obj = service.FromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);	
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Academico> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<AcademicoDTO>> findAll(){
		List<Academico> list = service.findAll();
		List<AcademicoDTO>listDTO = list.stream().map(obj ->new AcademicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<AcademicoDTO>> findPage(
			@RequestParam(value ="page", defaultValue = "0")Integer page, 
			@RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value ="orderBy", defaultValue = "observacao")String orderBy, 
			@RequestParam(value ="direction", defaultValue = "ASC")String direction){
		Page<Academico> list = service.findPage(page,linesPerPage, orderBy, direction);
		Page<AcademicoDTO>listDTO = list.map(obj ->new AcademicoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}
