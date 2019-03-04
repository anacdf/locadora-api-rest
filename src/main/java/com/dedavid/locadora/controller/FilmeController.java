package com.dedavid.locadora.controller;

import com.dedavid.locadora.model.Filme;
import com.dedavid.locadora.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<Filme>> findAll(){
        return ResponseEntity.ok(filmeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Filme>> findById(@PathVariable Long id){
        return ResponseEntity.ok(filmeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Filme> save(@RequestBody Filme filme){
        return ResponseEntity.ok(filmeService.save(filme));
    }

    @PutMapping
    public ResponseEntity<Filme> update(){
        return null;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return null;
    }
}
