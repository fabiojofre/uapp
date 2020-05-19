package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jofre.uapp.domain.Area;
import com.jofre.uapp.domain.Congregacao;
import com.jofre.uapp.dto.CongregacaoDTO;
import com.jofre.uapp.dto.CongregacaoNewDTO;
import com.jofre.uapp.repositories.CongregacaoRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class CongregacaoService {
	@Autowired
	private CongregacaoRepository repo;
	

	public Congregacao find(Integer id) {
		Optional<Congregacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Congregacao.class.getName()));
	}
	@Transactional
	public Congregacao insert(Congregacao obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Congregacao update(Congregacao obj) {
		Congregacao newObj = find(obj.getId());
		updateData(newObj, obj);
		obj =  repo.save(obj);
		return obj;
	}
	
	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Congregacao que tenha registros atrelados");
		}
	}
	public List<Congregacao>findAll(){
		return repo.findAll();
	}
	public Page<Congregacao>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public Congregacao fromDTO(CongregacaoDTO objDTO) {
		return new Congregacao(objDTO.getId(),objDTO.getNome(),objDTO.getResponsavel(),null);
	}
	public Congregacao fromDTO(CongregacaoNewDTO objDTO) {// criar sobrecarga para CongregacaoNewDTO
		Area area = new Area(objDTO.getAreaId(),null);
		Congregacao congregacao = new Congregacao(null,objDTO.getNome(),objDTO.getResponsavel(),area);
		return congregacao;
		
	}
	private void updateData(Congregacao newObj, Congregacao obj) {
		newObj.setNome(obj.getNome());
		newObj.setResponsavel(obj.getResponsavel());
	}
}
