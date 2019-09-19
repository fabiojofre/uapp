package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.Profissao;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {

}
