package com.dedavid.locadora.service;

import com.dedavid.locadora.model.Filme;
import com.dedavid.locadora.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    public Optional<Filme> findById(Long id) {
      return filmeRepository.findById(id);
    }

    public List<Filme> findAll() {
        return filmeRepository.findAll();
    }

    public Filme save(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Filme update(Long id, Filme filme) {
        Filme novo = this.findById(id).get();
        novo.builder()
                .diretor(filme.getDiretor())
                .titulo(filme.getTitulo())
                .build();
        return filmeRepository.save(novo);
    }

    public void delete(Long id) {
        filmeRepository.deleteById(id);
    }
}
