package com.kahindi.briskspringdemo.employee_profile.controllers;


import com.kahindi.briskspringdemo.employee_profile.records.EmployeeEntityrecord;
import com.kahindi.briskspringdemo.employee_profile.records.MIGPersonRecord;
import com.kahindi.briskspringdemo.employee_profile.services.EmployeeManagementService;
import com.kahindi.briskspringdemo.employee_profile.services.MIGPersonManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = {"/api/employees"})
@RequiredArgsConstructor
@Tag(name = "Employee Record Management.", description = "*Apis* to manage employee records.")
public class EmployeeManagementController {

    private final MIGPersonManagementService service;

    @Operation(
                    summary = "Get employee record by ID.",
                    description = ""
    )
    @GetMapping("/{employeeID}")
    public MIGPersonRecord getEmployeeRecordByID(@PathVariable @Validated long  employeeID) {
        return service.getMigPersonById(employeeID);
    }

    @Operation(
                    summary = "Add employee record to DB.",
                    description = ""
    )
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addEmployee(@RequestBody @Validated MIGPersonRecord employee) {
        service.addMigPerson(employee);
    }

    @Operation(
                    summary = "Get all employee records from DB.",
                    description = ""
    )
    @GetMapping
    public Slice<MIGPersonRecord> getAllEmployeeRecords(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size) {
        return service.getAllMigPersons(page, size);
    }

}
