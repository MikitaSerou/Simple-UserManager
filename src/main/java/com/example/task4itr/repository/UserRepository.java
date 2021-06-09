package com.example.task4itr.repository;

import com.example.task4itr.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
//    User findByUsername(String username);
//
//    @Query(value = "SELECT * FROM user Where e_mail = ?1", nativeQuery = true)
//    User findByEmail(String email);

}
