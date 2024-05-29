package com.kahindi.briskspringdemo.employee_profile.records;

import java.io.Serializable;

public record EmployeeEntityrecord(
        String employeeName,
        int employeeAge,
        String employeeDepartment
) implements Serializable {
}
