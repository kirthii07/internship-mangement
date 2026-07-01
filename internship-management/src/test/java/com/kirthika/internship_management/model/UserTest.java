package com.kirthika.internship_management.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void shouldSetAndGetAllFields() {
        User user = new User();

        user.setId(5L);
        user.setName("Nina");
        user.setEmail("nina@example.com");
        user.setPassword("secret123");
        user.setRole("ADMIN");

        assertEquals(5L, user.getId());
        assertEquals("Nina", user.getName());
        assertEquals("nina@example.com", user.getEmail());
        assertEquals("secret123", user.getPassword());
        assertEquals("ADMIN", user.getRole());
    }

    @Test
    void shouldDefaultToNullValuesWhenNotInitialized() {
        User user = new User();

        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
        assertNull(user.getRole());
    }
}
