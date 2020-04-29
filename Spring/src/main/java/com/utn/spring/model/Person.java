package com.utn.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor //constructor sin parametros
@AllArgsConstructor
@Data // getters y setters
@Builder //permite hacer q los SET devuelvan para encadenarlos y hacer programacion funcional
public class Person {

    @Id //primary key
    @GeneratedValue //autoincrement
    private Integer idPersona;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    private Integer salary;

    @NotNull
    private Integer edad;
    //TODO
    //Hacer filtro por edad
}
