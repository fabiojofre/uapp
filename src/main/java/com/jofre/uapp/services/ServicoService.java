package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Congregacao;
import com.jofre.uapp.domain.Servico;
import com.jofre.uapp.domain.TipoServico;
import com.jofre.uapp.dto.ServicoDTO;
import com.jofre.uapp.dto.ServicoNewDTO;
import com.jofre.uapp.enums.EnumStatusMovimento;
import com.jofre.uapp.repositories.ServicoRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class ServicoService {
	@Autowired
	private ServicoRepository repo;
	
	
	public Servico find(Integer id){
		Optional<Servico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Servico.class.getName()));	
	}
	
	public Servico insert(Servico obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Servico update(Servico obj) {
		Servico newObj = find(obj.getId());
		updateData(newObj, obj);
		obj =  repo.save(newObj);
		return obj;
	}
	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Servico que tenha registros atrelados");
		}
	}
	public List<Servico>findAll(){
		return repo.findAll();
	}
	public Page<Servico>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public Servico fromDTO(ServicoDTO objDTO) {
		return new Servico(null,objDTO.getObservacao(), EnumStatusMovimento.toEnum(objDTO.getStatus().getCod()),objDTO.getData(),null, null);
	}
	
	public Servico fromDTO(ServicoNewDTO objDTO) {// criar sobrecarga para CongregacaoNewDTO
		Congregacao congregacao = new Congregacao(objDTO.getCongregacaoId(),null,null,null);
		TipoServico tipoServico = new TipoServico(objDTO.getTiposervicoId(),null,null);
		Servico servico = new Servico(null,objDTO.getObservacao(), EnumStatusMovimento.toEnum(objDTO.getStatus().getCod()),objDTO.getData(),tipoServico, congregacao);
		return servico;
		
	}
	private void updateData(Servico newObj, Servico obj) {
		newObj.setObservacao(obj.getObservacao());
		newObj.setStatus(obj.getStatus());
		newObj.setData(obj.getData());	
	}

}
