package com.jofre.uapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jofre.uapp.domain.Congregacao;
import com.jofre.uapp.domain.Profissao;
import com.jofre.uapp.domain.Usuario;
import com.jofre.uapp.dto.UsuarioDTO;
import com.jofre.uapp.dto.UsuarioNewDTO;
import com.jofre.uapp.enums.EnumPoder;
import com.jofre.uapp.enums.EnumStatusCadastro;
import com.jofre.uapp.repositories.UsuarioRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private EmailService emailService;
	@Autowired
	private BCryptPasswordEncoder pe;

	
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Usuario.class.getName()));
	}
	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		emailService.sendOrderConfirmationEmail(obj);
		return repo.save(obj);
		
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		obj =  repo.save(newObj);
		return obj;
	}
	
	public void delete(Integer id) {
		find(id);
		try {	
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma entidade que tenha registros atrelados");
		}
	}
	public List<Usuario>findAll(){
		return repo.findAll();
	}
	public Page<Usuario>findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(),objDTO.getCpf(),objDTO.getCartaodemembro(),objDTO.getNome(),
				objDTO.getEmail(),objDTO.getSenha(),objDTO.getTelefone(),
				EnumStatusCadastro.toEnum(objDTO.getAtivo().getCod()),null,null);
	}
	public Usuario fromDTO(UsuarioNewDTO objDTO) {// criar sobrecarga para UsuarioNewDTO
		Congregacao congregacao = new Congregacao(objDTO.getCongregacaoId(),null,null,null);
		Profissao profissao = new Profissao(objDTO.getProfissaoId(),null);
		Usuario Usuario = new Usuario(null,objDTO.getCpf(),objDTO.getCartaodemembro(),
				objDTO.getNome(),objDTO.getEmail(),pe.encode(objDTO.getSenha()),objDTO.getTelefone(),
				EnumStatusCadastro.toEnum(objDTO.getAtivo().getCod()),
				congregacao,profissao);
		return Usuario;
		
	}
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setCpf(obj.getCpf());
		newObj.setCartaodemembro(obj.getCartaodemembro());
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
		newObj.setTelefone(obj.getTelefone());
		newObj.setAtivo(obj.getAtivo());
		newObj.setCongregacao(obj.getCongregacao());
		newObj.setProfissao(obj.getProfissao());
			
	}
}
