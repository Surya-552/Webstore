package com.ecom.webstore.repository;

import com.ecom.webstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    //Optional<User> findUserByEmail(String email);
    @Query("select u from User u where u.email=:email")
    Optional<User> findUserByEmail(@Param("email") String email);
}
