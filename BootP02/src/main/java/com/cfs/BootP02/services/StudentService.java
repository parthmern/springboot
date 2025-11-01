package com.cfs.BootP02.services;

import com.cfs.BootP02.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    public StudentRepo studentRepo;

    public String getStudentData(){
        return studentRepo.getStudentData();
    }

}
