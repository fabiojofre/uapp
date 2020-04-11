package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.FrequenciaEvento;

@Repository
public interface FrequenciaEventoRepository extends JpaRepository<FrequenciaEvento, Integer>{

}
