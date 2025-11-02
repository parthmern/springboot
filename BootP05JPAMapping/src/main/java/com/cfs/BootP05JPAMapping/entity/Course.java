package com.cfs.BootP05JPAMapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Table: course
 * Columns:
 *  id    -> PK
 *  title -> Course title
 */

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses")   // ✅ must match "courses" in Student
    @JsonIgnoreProperties("courses")
    private Set<Student> students = new HashSet<>();

}
