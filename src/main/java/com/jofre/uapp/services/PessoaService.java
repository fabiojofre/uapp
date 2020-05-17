package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Pessoa;
import com.jofre.uapp.repositories.PessoaRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa find(Integer id){
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Pessoa.class.getName()));
	}
	
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Pessoa update(Pessoa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Pessoa que tenha registros atrelados");
		}
	}
	public List<Pessoa>findAll(){
		return repo.findAll();
	}
	public Page<Pessoa>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}


}
