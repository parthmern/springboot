package com.cfs.BootP05JPAMapping.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Table: teacher
 * Columns:
 *  id      -> Primary Key
 *  name    -> Teacher's name
 */

// * Relationships:
//        *  students -> One-to-Many relationship with Student table

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "teacher")
    private List<Student> students = new ArrayList<>();
}
