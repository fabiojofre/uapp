package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.TipoServico;
import com.jofre.uapp.dto.TipoServicoDTO;
import com.jofre.uapp.repositories.TipoServicoRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class TipoServicoService {
	@Autowired
	private TipoServicoRepository repo;
	
	public TipoServico find(Integer id){
		Optional<TipoServico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoServico.class.getName()));		
	}
	public TipoServico insert(TipoServico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public TipoServico update(TipoServico obj) {
		TipoServico newObj = find(obj.getId());
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
	public List<TipoServico>findAll(){
		return repo.findAll();
	}
	
	//buscar uma lista por paginação
	public Page<TipoServico>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public TipoServico FromDTO(TipoServicoDTO objDTO) {	// Converte um domain num dto
		return new TipoServico(objDTO.getId(), objDTO.getDesc1(),objDTO.getDesc2());
	}
	private void updateData(TipoServico newObj, TipoServico obj) {
		newObj.setDesc1(obj.getDesc1());
		newObj.setDesc2(obj.getDesc2());
	}


}
