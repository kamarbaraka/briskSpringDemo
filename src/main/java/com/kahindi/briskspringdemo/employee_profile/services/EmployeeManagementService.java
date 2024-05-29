package com.kahindi.briskspringdemo.employee_profile.services;

import com.kahindi.briskspringdemo.employee_profile.records.EmployeeEntityrecord;
import com.kahindi.briskspringdemo.employee_profile.repositories.EmployeeEntityRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Slice;

import java.util.UUID;

public interface EmployeeManagementService {

    void addEmployee( @NotNull EmployeeEntityrecord employee);

    EmployeeEntityrecord getEmployeeRecordByID(UUID employeeID);

    Slice<EmployeeEntityrecord> getAllEmployeeRecords(int page, int size);
}
