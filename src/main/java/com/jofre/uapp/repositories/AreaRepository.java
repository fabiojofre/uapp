package com.jofre.uapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jofre.uapp.domain.Area;
import com.jofre.uapp.domain.Setor;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{
	
}
