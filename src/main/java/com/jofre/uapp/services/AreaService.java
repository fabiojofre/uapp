package com.jofre.uapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Area;
import com.jofre.uapp.repositories.AreaRepository;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class AreaService {
	@Autowired
	private AreaRepository repo;
	
	public Area find(Integer id){
		Optional<Area> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Area.class.getName()));		
	}
	public Area insert(Area obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Area update(Area obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
