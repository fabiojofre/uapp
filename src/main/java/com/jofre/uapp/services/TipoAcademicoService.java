package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.TipoAcademico;
import com.jofre.uapp.repositories.TipoAcademicoRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class TipoAcademicoService {
	@Autowired
	private TipoAcademicoRepository repo;
	
	public TipoAcademico find(Integer id){
		Optional<TipoAcademico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + TipoAcademico.class.getName()));		
	}
	public TipoAcademico insert(TipoAcademico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	

	public TipoAcademico update(TipoAcademico obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um TipoAcademico que tenha registros atrelados");
		}
	}
	public List<TipoAcademico>findAll(){
		return repo.findAll();
	}
	public Page<TipoAcademico>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}


}
