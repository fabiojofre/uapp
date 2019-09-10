package com.jofre.uapp.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/areas")
public class AreaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Rest está funciolnando";
	}

}
