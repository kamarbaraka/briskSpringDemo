package com.kahindi.briskspringdemo.employee_profile.records;

import java.io.Serializable;

public record VehicleRecord(
        String name,
        String model
) implements Serializable {
}
