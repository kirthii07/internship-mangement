package com.kirthika.internship_management.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class AttendanceTest {

    @Test
    void shouldSetAndGetAllFields() {
        Attendance attendance = new Attendance();
        LocalDate date = LocalDate.of(2026, 7, 1);

        attendance.setId(10L);
        attendance.setInternId(99L);
        attendance.setDate(date);
        attendance.setStatus("Present");

        assertEquals(10L, attendance.getId());
        assertEquals(99L, attendance.getInternId());
        assertEquals(date, attendance.getDate());
        assertEquals("Present", attendance.getStatus());
    }

    @Test
    void shouldDefaultToNullValuesWhenNotInitialized() {
        Attendance attendance = new Attendance();

        assertNull(attendance.getId());
        assertNull(attendance.getInternId());
        assertNull(attendance.getDate());
        assertNull(attendance.getStatus());
    }
}
