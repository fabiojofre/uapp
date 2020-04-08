package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jofre.uapp.domain.TipoEvento;

public interface TipoEventoRepository extends JpaRepository<TipoEvento, Integer> {

}
