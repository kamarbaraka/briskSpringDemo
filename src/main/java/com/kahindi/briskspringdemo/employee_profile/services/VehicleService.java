package com.kahindi.briskspringdemo.employee_profile.services;

import com.kahindi.briskspringdemo.employee_profile.records.VehicleRecord;

import java.util.List;

public interface VehicleService {

    void registerVehicle(VehicleRecord vehicleRecord);

    List<VehicleRecord> getAllVehicles();

    VehicleRecord getVehicleById(long id);

    void updateVehicle(VehicleRecord vehicleRecord);

    void deleteVehicle(long id);
}
