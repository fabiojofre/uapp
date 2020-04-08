package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.Ugrupo;

@Repository
public interface UserGrupoRepository extends JpaRepository<Ugrupo, Integer> {

}
