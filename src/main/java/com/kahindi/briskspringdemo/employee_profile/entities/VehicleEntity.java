package com.kahindi.briskspringdemo.employee_profile.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The VehicleEntity class represents a vehicle entity in the database.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Entity
@Table(name = "vehicles")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicleID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String model;

}
