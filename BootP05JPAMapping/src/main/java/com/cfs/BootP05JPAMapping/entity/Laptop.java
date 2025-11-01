package com.cfs.BootP05JPAMapping.entity;
import jakarta.persistence.*;
/**
 * Table: laptop
 * Columns:
 *  id          -> Primary Key
 *  brand       -> Laptop brand name
 *  student_id  -> FK (references student.id)
 */

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    @OneToOne
    @JoinColumn(name="student_id", unique = true)
    private Student student;    // FK "student_id"
}
