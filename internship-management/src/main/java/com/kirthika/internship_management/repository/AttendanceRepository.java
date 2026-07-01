package com.kirthika.internship_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kirthika.internship_management.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}