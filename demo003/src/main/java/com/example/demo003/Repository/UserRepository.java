package com.example.demo003.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo003.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
