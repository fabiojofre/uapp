package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{

}
