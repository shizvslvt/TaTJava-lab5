package com.example.tatjavalab5.repository;

import com.example.tatjavalab5.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
