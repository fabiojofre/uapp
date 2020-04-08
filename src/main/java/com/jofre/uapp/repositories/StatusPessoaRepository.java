package com.jofre.uapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jofre.uapp.domain.Spessoa;
@Repository
public interface StatusPessoaRepository extends JpaRepository<Spessoa, Integer> {

}
