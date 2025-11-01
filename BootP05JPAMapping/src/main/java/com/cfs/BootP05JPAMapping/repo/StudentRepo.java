package com.cfs.BootP05JPAMapping.repo;

import com.cfs.BootP05JPAMapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
