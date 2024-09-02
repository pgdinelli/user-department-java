package com.pgdinelli.userdept.entities;

import jakarta.persistence.*;

@Entity //indica que a classe será uma tabela no banco de dados
@Table(name = "tb_user") //indica o nome da tabela no banco através do atributo name
public class User {

    @Id //indica que o atributo abaixo será uma chave primária no banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o valor incremental do id
    private Long id;
    private String name;
    private String email;

    @ManyToOne //indica a relação muitos para 1 da classe usuário com a classe departamento
    @JoinColumn(name = "department_id") //indica o nome da chave estrangeira no banco
    private Department department;

    public User(){}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
