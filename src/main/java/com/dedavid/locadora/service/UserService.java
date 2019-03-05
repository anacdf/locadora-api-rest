package com.dedavid.locadora.service;

import com.dedavid.locadora.model.User;
import com.dedavid.locadora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User novo = this.findById(id).orElseThrow(IllegalArgumentException::new);
        novo.builder()
                .nome(user.getNome())
                .telefone(user.getTelefone())
                .build();
        return userRepository.save(novo);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
