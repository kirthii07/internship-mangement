package com.kirthika.internship_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirthika.internship_management.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}