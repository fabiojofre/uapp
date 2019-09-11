package com.jofre.uapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jofre.uapp.domain.Area;
import com.jofre.uapp.services.AreaService;

@RestController
@RequestMapping(value="/areas")
public class AreaResource {
	
	@Autowired
	private AreaService service; 
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Area obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
