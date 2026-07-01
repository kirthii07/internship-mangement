package com.kirthika.internship_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kirthika.internship_management.model.Intern;

public interface InternRepository extends JpaRepository<Intern, Long> {

}