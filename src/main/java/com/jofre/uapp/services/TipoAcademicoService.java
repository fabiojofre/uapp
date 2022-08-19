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
import com.jofre.uapp.dto.TipoAcademicoDTO;
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
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoAcademico.class.getName()));		
	}
	public TipoAcademico insert(TipoAcademico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public TipoAcademico update(TipoAcademico obj) {
		TipoAcademico newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	

	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma entidade que tenha dependências atreladas");
		}
	}
	public List<TipoAcademico>findAll(){
		return repo.findAll();
	}
	
	//buscar uma lista por paginação
	public Page<TipoAcademico>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public TipoAcademico FromDTO(TipoAcademicoDTO objDTO) {	// Converte um domain num dto
		return new TipoAcademico(objDTO.getId(), objDTO.getDesc1(),objDTO.getDesc2());
	}
	private void updateData(TipoAcademico newObj, TipoAcademico obj) {
		newObj.setDesc1(obj.getDesc1());
		newObj.setDesc2(obj.getDesc2());
	}
}
