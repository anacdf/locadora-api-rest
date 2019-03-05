package com.dedavid.locadora.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FILME")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Filme {

    @Id
  //  @GeneratedValue
    private Long id;

    private String titulo;

    private String diretor;
}
