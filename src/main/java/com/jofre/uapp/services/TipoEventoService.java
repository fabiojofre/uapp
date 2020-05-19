package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.TipoEvento;
import com.jofre.uapp.dto.TipoEventoDTO;
import com.jofre.uapp.repositories.TipoEventoRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class TipoEventoService {
	@Autowired
	private TipoEventoRepository repo;
	
	public TipoEvento find(Integer id){
		Optional<TipoEvento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoEvento.class.getName()));		
	}
	public TipoEvento insert(TipoEvento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public TipoEvento update(TipoEvento obj) {
		TipoEvento newObj = find(obj.getId());
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
	public List<TipoEvento>findAll(){
		return repo.findAll();
	}
	
	//buscar uma lista por paginação
	public Page<TipoEvento>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public TipoEvento FromDTO(TipoEventoDTO objDTO) {	// Converte um domain num dto
		return new TipoEvento(objDTO.getId(), objDTO.getDesc1(),objDTO.getDesc2());
	}
	private void updateData(TipoEvento newObj, TipoEvento obj) {
		newObj.setDesc1(obj.getDesc1());
		newObj.setDesc2(obj.getDesc2());
	}

}
