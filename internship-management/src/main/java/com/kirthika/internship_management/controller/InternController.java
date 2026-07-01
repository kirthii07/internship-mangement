package com.kirthika.internship_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kirthika.internship_management.model.Intern;
import com.kirthika.internship_management.repository.InternRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/interns")
public class InternController {

    @Autowired
    private InternRepository repository;

    @PostMapping
    public Intern addIntern(@RequestBody Intern intern) {
        return repository.save(intern);
    }

    @GetMapping
    public List<Intern> getAllInterns() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Intern updateIntern(@PathVariable Long id,
                               @RequestBody Intern updatedIntern) {

        Intern intern = repository.findById(id).orElseThrow();

        intern.setName(updatedIntern.getName());
        intern.setCollege(updatedIntern.getCollege());
        intern.setDepartment(updatedIntern.getDepartment());
        intern.setEmail(updatedIntern.getEmail());
        intern.setDuration(updatedIntern.getDuration());
        intern.setRole(updatedIntern.getRole());
        intern.setStartDate(updatedIntern.getStartDate());
        intern.setEndDate(updatedIntern.getEndDate());

        return repository.save(intern);
    }

    @DeleteMapping("/{id}")
    public String deleteIntern(@PathVariable Long id) {

        repository.deleteById(id);

        return "Intern Deleted Successfully";
    }
}