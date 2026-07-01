package com.kirthika.internship_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kirthika.internship_management.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}