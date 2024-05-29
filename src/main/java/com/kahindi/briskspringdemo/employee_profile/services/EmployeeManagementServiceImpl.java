package com.kahindi.briskspringdemo.employee_profile.services;

import com.kahindi.briskspringdemo.employee_profile.entities.EmployeeEntity;
import com.kahindi.briskspringdemo.employee_profile.records.EmployeeEntityrecord;
import com.kahindi.briskspringdemo.employee_profile.repositories.EmployeeEntityRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeManagementServiceImpl implements EmployeeManagementService{

    private final EmployeeEntityRepository repository;

    @Override
    public void addEmployee(@NotNull EmployeeEntityrecord employee) {

        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .employeeName(employee.employeeName())
                .employeeAge(employee.employeeAge())
                .employeeDepartment(employee.employeeDepartment())
                .build();

        repository.save(employeeEntity);
    }

    @Override
    public EmployeeEntityrecord getEmployeeRecordByID(UUID employeeID) {

        EmployeeEntity employeeEntityRecord = repository.findById(employeeID)
                .orElseThrow(() -> new NoSuchElementException("can't locate the user"));

        return new EmployeeEntityrecord(
                employeeEntityRecord.getEmployeeName(),
                employeeEntityRecord.getEmployeeAge(),
                employeeEntityRecord.getEmployeeDepartment()
        );
    }

    @Override
    public Slice<EmployeeEntityrecord> getAllEmployeeRecords(int page, int size) {

        Slice<EmployeeEntity> employeeEntities = repository.findAll(PageRequest.of(page, size));
        List<EmployeeEntityrecord> employeeRecords = employeeEntities.stream()
                .map(employeeEntity -> new EmployeeEntityrecord(
                        employeeEntity.getEmployeeName(),
                        employeeEntity.getEmployeeAge(),
                        employeeEntity.getEmployeeDepartment()
                ))
                .collect(Collectors.toList());
        return new SliceImpl<>(employeeRecords, PageRequest.of(page, size), employeeEntities.hasNext());
    }
}
