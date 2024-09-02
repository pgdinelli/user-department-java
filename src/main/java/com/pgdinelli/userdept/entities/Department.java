package com.pgdinelli.userdept.entities;

import jakarta.persistence.*;

@Entity //annotation que indica que a classe será uma tabela no banco de dados
@Table(name = "tb_department") //annotation com atributo name indicando qual será o nome da tabela no banco
public class Department {
    @Id //annotation indicando que o id abaixo será a chave primária do banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o valor incremental do id
    private Long id;
    private String name;

    public Department(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
