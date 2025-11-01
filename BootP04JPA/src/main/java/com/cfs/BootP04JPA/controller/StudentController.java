package com.cfs.BootP04JPA.controller;

import com.cfs.BootP04JPA.entity.Student;
import com.cfs.BootP04JPA.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    // "final" keyword must be initialized in the constructor
    // u can still use @Autowire + constructor ( but no need )
    private final StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {    // JSON REQ: {"name": "Part", "email":"ss@gm.c" }
        return studentRepo.save(student);   // saving in DB
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepo.findAll();   // from db
    }




}
