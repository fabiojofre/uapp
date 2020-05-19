package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Profissao;
import com.jofre.uapp.dto.ProfissaoDTO;
import com.jofre.uapp.repositories.ProfissaoRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class ProfissaoService {
	@Autowired
	private ProfissaoRepository repo;
	
	public Profissao find(Integer id){
		Optional<Profissao>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Profissao.class.getName()));
	}
	public Profissao insert(Profissao obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Profissao update(Profissao obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Profissão que tenha registros atrelados");
		}
	}
	public List<Profissao>findAll(){
		return repo.findAll();
	}
	public Page<Profissao>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public Profissao FromDTO(ProfissaoDTO objDTO) {
		return new Profissao(objDTO.getId(), objDTO.getProfissao());
	}


}
