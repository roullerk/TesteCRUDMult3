package com.mult3.testemult3.controller;

import java.util.List;

import com.mult3.testemult3.model.Pessoa;
import com.mult3.testemult3.repository.RepositoryPessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
@CrossOrigin("*")
public class ControllerPessoa {
    
    @Autowired
    private RepositoryPessoa repository;

    @GetMapping
    public Iterable<Pessoa> list(){
        return repository.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Pessoa> GetById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Pessoa>> GetByNome(@PathVariable String nome){
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }

    @GetMapping("/idade/{idade}")
    public ResponseEntity<List<Pessoa>> GetByIdade(@PathVariable int idade){
        return ResponseEntity.ok(repository.findAllByIdadeContainingIgnoreCase(idade));
    }

    @PostMapping
    public ResponseEntity<Pessoa> Post(@RequestBody Pessoa pessoa){
        return  ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
    }

    @PutMapping
    public ResponseEntity<Pessoa> put(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable long id){
        repository.deleteById(id);
    }


}
