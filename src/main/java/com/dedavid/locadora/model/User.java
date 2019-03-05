package com.dedavid.locadora.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
 //   @GeneratedValue
    private Long id;

    private String nome;

    private String telefone;

}
