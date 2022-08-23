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

import com.jofre.uapp.domain.Congregacao;
import com.jofre.uapp.domain.Pessoa;
import com.jofre.uapp.domain.Profissao;
import com.jofre.uapp.dto.PessoaDTO;
import com.jofre.uapp.dto.PessoaNewDTO;
import com.jofre.uapp.enums.EnumConfirmacao;
import com.jofre.uapp.enums.EnumSituacaoPessoa;
import com.jofre.uapp.enums.EnumStatusCadastro;
import com.jofre.uapp.enums.EnumTipoPessoa;
import com.jofre.uapp.repositories.PessoaRepository;
import com.jofre.uapp.services.exception.DataIntegrityException;
import com.jofre.uapp.services.exception.ObjectNotFoundException;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository repo;

	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Pessoa.class.getName()));
	}

	@Transactional
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Pessoa update(Pessoa obj) {
		Pessoa newObj = find(obj.getId());
		updateData(newObj, obj);
		obj = repo.save(newObj);
		return obj;
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma entidade que tenha registros atrelados");
		}
	}

	public List<Pessoa> findAll() {
		return repo.findAll();
	}

	public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Pessoa fromDTO(PessoaDTO objDTO) {
		return new Pessoa(null, EnumStatusCadastro.toEnum(objDTO.getAtivo().getCod()), objDTO.getNome(),
				objDTO.getNascimento(), EnumConfirmacao.toEnum(objDTO.geteMembro().getCod()), objDTO.getFone(),
				objDTO.getNomePai(), objDTO.getFonePai(), objDTO.getNomeMae(), objDTO.getFoneMae(),
				EnumConfirmacao.toEnum(objDTO.getPaiMembro().getCod()), EnumConfirmacao.toEnum(objDTO.getMaeMembro().getCod()), 
				objDTO.getEndereco(),EnumTipoPessoa.toEnum(objDTO.getTipoPessoa().getCod()), 
				EnumSituacaoPessoa.toEnum(objDTO.getSituacaoPessoa().getCod()),null, null);
	}

	public Pessoa fromDTO(PessoaNewDTO objDTO) {// criar sobrecarga para PessoaNewDTO
		Profissao profissao = new Profissao(objDTO.getProfissaoId(), null);

		Congregacao congregacao = new Congregacao(objDTO.getCongregacaoId(), null, null, null);

		Pessoa Pessoa = new Pessoa(null, EnumStatusCadastro.toEnum(objDTO.getAtivo().getCod()), objDTO.getNome(),
				objDTO.getNascimento(), EnumConfirmacao.toEnum(objDTO.geteMembro().getCod()), objDTO.getFone(),
				objDTO.getNomePai(), objDTO.getFonePai(), objDTO.getNomeMae(), objDTO.getFoneMae(),
				EnumConfirmacao.toEnum(objDTO.getPaiMembro().getCod()), EnumConfirmacao.toEnum(objDTO.getMaeMembro().getCod()), 
				objDTO.getEndereco(),EnumTipoPessoa.toEnum(objDTO.getTipoPessoa().getCod()), 
				EnumSituacaoPessoa.toEnum(objDTO.getSituacaoPessoa().getCod()),congregacao, profissao);
		return Pessoa;

	}

	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setAtivo(obj.getAtivo());
		newObj.setNome(obj.getNome());
		newObj.setNascimento(obj.getNascimento());
		newObj.seteMembro(obj.geteMembro());
		newObj.setFone(obj.getFone());
		newObj.setNomePai(obj.getNomePai());
		newObj.setFonePai(obj.getFonePai());
		newObj.setNomeMae(obj.getFoneMae());
		newObj.setFoneMae(obj.getFoneMae());
		newObj.setPaiMembro(obj.getPaiMembro());
		newObj.setMaeMembro(obj.getMaeMembro());
		newObj.setEndereco(obj.getEndereco());
		newObj.setTipoPessoa(obj.getTipoPessoa());
		newObj.setSituacaoPessoa(obj.getSituacaoPessoa());
	}

}
