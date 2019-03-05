package com.dedavid.locadora.controller;

import com.dedavid.locadora.model.Filme;
import com.dedavid.locadora.service.FilmeService;
import com.google.common.base.Preconditions;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//http://localhost:8080/filmes/swagger-ui.html

@RestController
@RequestMapping("/filmes")
//@Api(value="Filmes", produces = MediaType.APPLICATION_JSON_VALUE)
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @ApiOperation("Listar todos os filmes")
    @GetMapping
    public ResponseEntity<List<Filme>> findAll(){
        return ResponseEntity.ok().body(filmeService.findAll());
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Encontrar um filme pelo ID")
    public ResponseEntity<Optional<Filme>> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(filmeService.findById(id));
    }

    @PostMapping
    @ApiOperation("Salvar um novo filme")
    public ResponseEntity<Filme> save(@RequestBody Filme filme){
        Preconditions.checkNotNull(filme);
        return ResponseEntity.ok().body(filmeService.save(filme));
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Atualizar um filme")
    public ResponseEntity<Filme> update(@PathVariable Long id, @RequestBody Filme filme){
        Preconditions.checkNotNull(filme);
        return ResponseEntity.ok().body(filmeService.update(id, filme));
    }

    @DeleteMapping(value="delete/{id}")
    @ApiOperation("deletar um filme")
    public ResponseEntity.BodyBuilder delete(@PathVariable Long id){
        filmeService.delete(id);
        return ResponseEntity.ok();
    }
}
