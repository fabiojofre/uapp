package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Evento;
import com.jofre.uapp.domain.TipoEvento;
import com.jofre.uapp.dto.EventoDTO;
import com.jofre.uapp.dto.EventoNewDTO;
import com.jofre.uapp.enums.EnumStatusMovimento;
import com.jofre.uapp.repositories.EventoRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class EventoService {
	@Autowired
	private EventoRepository repo;
	
	public Evento find(Integer id) {
		Optional<Evento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Evento.class.getName()));
	}
	
	public Evento insert(Evento obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Evento update(Evento obj) {
		Evento newObj =	find(obj.getId());
		updateData(newObj, obj);
		obj = repo.save(newObj);
		return obj;
	}
	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Evento que tenha registros atrelados");
		}
	}
	public List<Evento>findAll(){
		return repo.findAll();
	}
	public Page<Evento>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public Evento fromDTO(EventoDTO objDTO) {
		return new Evento(null, objDTO.getObservacao(),EnumStatusMovimento.toEnum(objDTO.getStatus().getCod()),objDTO.getData(), null);
	}
	public Evento fromDTO(EventoNewDTO objDTO) {
		TipoEvento tipoEvento = new TipoEvento(objDTO.getTipoeventoId(),null,null);
		Evento evento =  new Evento(null, objDTO.getObservacao(),EnumStatusMovimento.toEnum(objDTO.getStatus().getCod()),objDTO.getData(), tipoEvento);
		return evento;
	}
	private void updateData(Evento newObj, Evento obj) {
		newObj.setObservacao(obj.getObservacao());
		newObj.setStatus(obj.getStatus());
		newObj.setData(obj.getData());	
	}
}
