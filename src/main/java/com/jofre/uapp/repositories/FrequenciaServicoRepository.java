package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.FrequenciaServico;

@Repository
public interface FrequenciaServicoRepository extends JpaRepository<FrequenciaServico, Integer>{

}
