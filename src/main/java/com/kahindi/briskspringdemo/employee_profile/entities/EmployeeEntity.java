package com.kahindi.briskspringdemo.employee_profile.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Represents an employee entity.
 *
 * An employee entity has an ID, name, age, and department.
 *
 * This class is used to persist employee information in the database.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Entity
@Table(name = "employees")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {

    /**
     * Represents the employee ID of an employee entity.
     *
     * The employee ID is a universally unique identifier (UUID) generated
     * using the "IDENTITY" strategy with the "UUID" generator.
     *
     * @see EmployeeEntity
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID employeeID;

    private String employeeName;

    private int employeeAge;

    private String employeeDepartment;
}
