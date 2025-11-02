package com.cfs.BootP05JPAMapping.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
/**
 * Table: student
 * Columns:
 *  id       -> PK
 *  name     -> Student's name
 */

// ===========================

/**
 * Table: student
 * Columns:
 *  id         -> PK
 *  name       -> Student's name
 *  teacher_id -> FK referencing Teacher table
 */

// ===========================

/**
 * Join Table: student_course
 * Columns:
 *  student_id -> FK referencing student.id
 *  course_id  -> FK referencing course.id
 */

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;

    @ManyToOne(fetch = FetchType.LAZY)  // while working with mapping performace issue
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            name="student_course",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnoreProperties("students")
    public Set<Course> courses=new HashSet<>();


    // getter setter for all generated
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
