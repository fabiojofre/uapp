package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Setor;
import com.jofre.uapp.dto.SetorDTO;
import com.jofre.uapp.repositories.SetorRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class SetorService {
	@Autowired
	private SetorRepository repo;
	
	public Setor find(Integer id){
		Optional<Setor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Setor.class.getName()));		
	}

	public Setor insert(Setor obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Setor update(Setor obj) {
		Setor newObj = find(obj.getId());
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
	public List<Setor>findAll(){
		return repo.findAll();
	}
	
	//buscar uma lista por paginação
	public Page<Setor>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Setor FromDTO(SetorDTO objDTO) {	// Converte um domain num dto
		return new Setor(objDTO.getId(), objDTO.getNome(), objDTO.getSetor());
	}
	
	private void updateData(Setor newObj, Setor obj) {
		newObj.setSetor(obj.getSetor());
		newObj.setSetor(obj.getSetor());
	}
}
