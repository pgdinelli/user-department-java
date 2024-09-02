package com.pgdinelli.userdept.controllers;

import com.pgdinelli.userdept.entities.User;
import com.pgdinelli.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //indica que a classe é um controlador REST
@RequestMapping(value = "/users") //indica qual caminho o controlador irá responder
public class UserController { //uma classe controller é responsável por receber requisições do usuário e responder as requisições , sendo ela um controlador REST da API

    @Autowired //annotation para injeção de dependência, para que não precise ficar instanciando o objeto do tipo UserRepository com new e sem necessidade de fazer injeção via construtor
    private UserRepository repository; //composição de componentes com a finalidade de acessar aos dados do banco

    @GetMapping //Annotation que indica qual verbo HTTP será usado (GET, POST, PUT, DELETE), neste caso usaremos a requisição GET para resgatar um dado
    public List<User> findAll(){ //Cria um método para percorrer todos os usuários do banco, para isso use-se um objeto List do tipo User
        return repository.findAll(); //o método findAll da classe repository automaticamente retorna uma lista com todos os usuários cadastrados
    }

    @GetMapping (value = "/{id}") //o atributo value indica que a requisição será feita em um id específico
    public User findById(@PathVariable Long id){ //Cria um método para retornar um único usuário pelo seu id, a anotação PathVariable indica que o usuário será acessado pelo valor do id
        return repository.findById(id).get(); //o método findById da classe repository retorna um objeto Optional, o valor do id encontra-se dentro desse objeto, para pegar esse valor usa-se o método get()
    }

    @PostMapping //Annotation PostMapping indica que estamos usando a requisição http POST, para salvar um usuário no banco
    public User insert(@RequestBody User user){ //Cria um método para salvar um usuário, a anotação RequestBody indica que o objeto user será o corpo da requisição POST
        return repository.save(user); //método save da classe repository usado para salvar um usuário que é passado como parâmetro
    }
}
