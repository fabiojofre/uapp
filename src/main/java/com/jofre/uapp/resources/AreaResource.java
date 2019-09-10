package com.jofre.uapp.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jofre.uapp.domain.Area;

@RestController
@RequestMapping(value="/areas")
public class AreaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Area> listar() {
		Area area1 = new Area(1, "Area 1");
		Area area2 = new Area(2, "Area 2");
		
		List<Area>lista = new ArrayList<>();
		lista.add(area1);
		lista.add(area2);
		
		return lista;
	}

}
