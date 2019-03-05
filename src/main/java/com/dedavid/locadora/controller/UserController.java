package com.dedavid.locadora.controller;

import com.dedavid.locadora.model.User;
import com.dedavid.locadora.service.UserService;
import com.google.common.base.Preconditions;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation("Listar todos os usuários")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Encontrar um usuário pelo ID")
    public Optional<User> findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Salvar um novo usuário")
    public User save(@RequestBody User user){
        Preconditions.checkNotNull(user);
        return userService.save(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Atualizar um usuário")
    public User update(@PathVariable Long id, @RequestBody User user){
        Preconditions.checkNotNull(user);
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("deletar um usuário")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
