package com.cfs.BootP05JPAMapping.repo;

import com.cfs.BootP05JPAMapping.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop, Long> {
}
