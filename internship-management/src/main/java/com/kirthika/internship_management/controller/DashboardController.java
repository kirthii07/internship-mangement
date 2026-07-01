package com.kirthika.internship_management.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kirthika.internship_management.repository.AttendanceRepository;
import com.kirthika.internship_management.repository.InternRepository;
import com.kirthika.internship_management.repository.TaskRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private InternRepository internRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping
    public Map<String, Long> getDashboardData() {

        Map<String, Long> data = new HashMap<>();

        data.put("interns", internRepository.count());
        data.put("tasks", taskRepository.count());
        data.put("attendance", attendanceRepository.count());

        return data;
    }
}