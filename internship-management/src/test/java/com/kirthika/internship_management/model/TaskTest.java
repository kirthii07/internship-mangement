package com.kirthika.internship_management.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    void shouldSetAndGetAllFields() {
        Task task = new Task();

        task.setId(7L);
        task.setInternId(21L);
        task.setTitle("Write tests");
        task.setDescription("Create unit tests for the service layer");
        task.setStatus("In Progress");

        assertEquals(7L, task.getId());
        assertEquals(21L, task.getInternId());
        assertEquals("Write tests", task.getTitle());
        assertEquals("Create unit tests for the service layer", task.getDescription());
        assertEquals("In Progress", task.getStatus());
    }

    @Test
    void shouldDefaultToNullValuesWhenNotInitialized() {
        Task task = new Task();

        assertNull(task.getId());
        assertNull(task.getInternId());
        assertNull(task.getTitle());
        assertNull(task.getDescription());
        assertNull(task.getStatus());
    }
}
