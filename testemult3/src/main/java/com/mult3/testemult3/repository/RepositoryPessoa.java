package com.mult3.testemult3.repository;

import java.util.List;

import com.mult3.testemult3.model.Pessoa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPessoa extends CrudRepository<Pessoa, Long> {
    
    public List<Pessoa> findAllByNomeContainingIgnoreCase(String nome);
}
