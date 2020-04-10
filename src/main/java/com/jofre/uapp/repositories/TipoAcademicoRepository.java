package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.TipoAcademico;

@Repository
public interface TipoAcademicoRepository extends JpaRepository<TipoAcademico, Integer>{

}
