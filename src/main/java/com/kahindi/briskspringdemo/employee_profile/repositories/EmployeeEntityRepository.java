package com.kahindi.briskspringdemo.employee_profile.repositories;

import com.kahindi.briskspringdemo.employee_profile.entities.EmployeeEntity;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, UUID> {


}
