package com.pgdinelli.userdept.repositories;

import com.pgdinelli.userdept.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { //Uma classe repository indica que é onde serão acessados os dados de cada entidade, neste caso queremos realizar consultas nos dados dos usuários

}
