package com.cfs.BootP05JPAMapping.entity;
import jakarta.persistence.*;
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
