package com.example.classworkapi.repositories;

import com.example.classworkapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    @Query(value = "UPDATE users SET username = ?1 WHERE id = ?2", nativeQuery = true)
    Users updateUser(String username, Long id);
}
