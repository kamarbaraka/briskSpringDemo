package com.kahindi.briskspringdemo.employee_profile.services;


import com.kahindi.briskspringdemo.employee_profile.entities.VehicleEntity;
import com.kahindi.briskspringdemo.employee_profile.records.VehicleRecord;
import com.kahindi.briskspringdemo.employee_profile.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public void registerVehicle(VehicleRecord vehicleRecord) {

        VehicleEntity vehicleEntity = VehicleEntity.builder()
                .name(vehicleRecord.name())
                .model(vehicleRecord.model())
                .build();

        vehicleRepository.save(vehicleEntity);
    }

    @Override
    public List<VehicleRecord> getAllVehicles() {

        return vehicleRepository.findAll()
                .stream()
                .map(vehicle -> new VehicleRecord(vehicle.getName(), vehicle.getModel()))
                .toList();
    }

    @Override
    public VehicleRecord getVehicleById(long id) {

        return vehicleRepository.findById(id)
                .map(vehicle -> new VehicleRecord(vehicle.getName(), vehicle.getModel()))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void updateVehicle(VehicleRecord vehicleRecord) {

    }

    /**
     *
     */
    @Override
    public void deleteVehicle(long id) {

        vehicleRepository.deleteById(id);
    }

}
