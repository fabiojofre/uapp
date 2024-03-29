package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>{
}
