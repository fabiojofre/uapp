package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.FrequenciaAcademico;

@Repository
public interface FrequenciaAcademicoRepository extends JpaRepository<FrequenciaAcademico, Integer>{

}
