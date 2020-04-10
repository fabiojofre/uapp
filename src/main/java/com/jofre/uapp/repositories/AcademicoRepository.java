package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.Academico;

@Repository
public interface AcademicoRepository extends JpaRepository<Academico, Integer>{

}
