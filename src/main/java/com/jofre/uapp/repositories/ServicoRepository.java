package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

}
