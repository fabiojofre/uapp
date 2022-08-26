package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jofre.uapp.domain.Academico;
import com.jofre.uapp.domain.TipoAcademico;
import com.jofre.uapp.dto.AcademicoDTO;
import com.jofre.uapp.dto.AcademicoNewDTO;
import com.jofre.uapp.enums.EnumStatusMovimento;
import com.jofre.uapp.repositories.AcademicoRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;


@Service
public class AcademicoService {
	@Autowired
	private AcademicoRepository repo;
	
	
	public Academico find(Integer id) {
		Optional<Academico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id +", tipo: " + Academico.class.getName()));	
	}
	public Academico insert(Academico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Academico update(Academico obj) {
		Academico newObj = find(obj.getId());
		updateData(newObj, obj);
		obj =  repo.save(newObj);
		return obj;
	}
	
	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Registro que tenha outros registros atrelados");
		}
	}
	public List<Academico>findAll(){
		return repo.findAll();
	}
	public Page<Academico>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public Academico FromDTO(AcademicoDTO objDTO) {
		return new Academico(null,objDTO.getObservacao(), EnumStatusMovimento.toEnum(objDTO.getStatus().getCod()) ,objDTO.getDataInicio(), objDTO.getDataFim(),null);
	}
	public Academico fromDTO(AcademicoNewDTO objDTO) {// criar sobrecarga para CongregacaoNewDTO
		TipoAcademico tipoAcademico = new TipoAcademico(objDTO.getTipoAcademicoId(),null,null);
		Academico academico = new Academico(null,objDTO.getObservacao(), EnumStatusMovimento.toEnum(objDTO.getStatus().getCod()),objDTO.getDataInicio(), objDTO.getDataFim(),tipoAcademico);
		return academico;
		
	}
	private void updateData(Academico newObj, Academico obj) {
		newObj.setObservacao(obj.getObservacao());
		newObj.setStatus(obj.getStatus());
		newObj.setDataFim(obj.getDataFim());
		newObj.setDataInicio(obj.getDataInicio());
	}
	

}
