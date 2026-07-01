package com.kirthika.internship_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kirthika.internship_management.model.Attendance;
import com.kirthika.internship_management.repository.AttendanceRepository;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository repository;

    @PostMapping
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        return repository.save(attendance);
    }

    @GetMapping
    public List<Attendance> getAttendance() {
        return repository.findAll();
    }
}