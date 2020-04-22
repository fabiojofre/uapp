package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.TipoPessoa;
import com.jofre.uapp.repositories.TipoPessoaRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class TipoPessoaService {
	@Autowired
	private TipoPessoaRepository repo;
	
	public TipoPessoa find(Integer id){
		Optional<TipoPessoa>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + TipoPessoa.class.getName()));	
	}
	public TipoPessoa insert(TipoPessoa obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public TipoPessoa update(TipoPessoa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um TipoPessoa que tenha registros atrelados");
		}
	}
	public List<TipoPessoa>findAll(){
		return repo.findAll();
	}

}
