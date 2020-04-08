package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Area;
import com.jofre.uapp.repositories.AreaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AreaService {
	@Autowired
	private AreaRepository ar;
	
	public Area find(Integer id) throws ObjectNotFoundException {
		Optional<Area> obj = ar.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Area.class.getName()));

			
	}

}
