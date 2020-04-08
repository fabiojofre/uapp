package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.mov.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{

}
