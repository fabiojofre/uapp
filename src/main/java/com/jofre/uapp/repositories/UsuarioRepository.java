package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.Congregacao;

@Repository
public interface UsuarioRepository extends JpaRepository<Congregacao, Integer> {

}
