package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Area;
import com.jofre.uapp.dto.AreaDTO;
import com.jofre.uapp.repositories.AreaRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
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
		Area newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(obj);
	}
	

	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma entidade que tenha dependências atreladas");
		}
	}
	public List<Area>findAll(){
		return repo.findAll();
	}
	
	//buscar uma lista por paginação
	public Page<Area>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public Area FromDTO(AreaDTO objDTO) {	// Converte um domain num dto
		return new Area(objDTO.getId(), objDTO.getNome(), objDTO.getSetor());
	}
	private void updateData(Area newObj, Area obj) {
		newObj.setNome(obj.getNome());
	}
}
