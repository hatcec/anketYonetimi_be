package com.example.AnketYonetimi.dataAccess;

import com.example.AnketYonetimi.entities.Role;
import com.example.AnketYonetimi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findByRole(Role role);
}
