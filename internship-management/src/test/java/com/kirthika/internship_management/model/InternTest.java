package com.kirthika.internship_management.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class InternTest {

    @Test
    void shouldSetAndGetAllFields() {
        Intern intern = new Intern();

        intern.setId(1L);
        intern.setName("Asha");
        intern.setCollege("ABC College");
        intern.setDepartment("Computer Science");
        intern.setEmail("asha@example.com");
        intern.setDuration("3 months");
        intern.setRole("Developer");
        intern.setStartDate("2026-01-01");
        intern.setEndDate("2026-03-31");

        assertEquals(1L, intern.getId());
        assertEquals("Asha", intern.getName());
        assertEquals("ABC College", intern.getCollege());
        assertEquals("Computer Science", intern.getDepartment());
        assertEquals("asha@example.com", intern.getEmail());
        assertEquals("3 months", intern.getDuration());
        assertEquals("Developer", intern.getRole());
        assertEquals("2026-01-01", intern.getStartDate());
        assertEquals("2026-03-31", intern.getEndDate());
    }

    @Test
    void shouldDefaultToNullValuesWhenNotInitialized() {
        Intern intern = new Intern();

        assertNull(intern.getId());
        assertNull(intern.getName());
        assertNull(intern.getCollege());
        assertNull(intern.getDepartment());
        assertNull(intern.getEmail());
        assertNull(intern.getDuration());
        assertNull(intern.getRole());
        assertNull(intern.getStartDate());
        assertNull(intern.getEndDate());
    }
}
