package com.kahindi.briskspringdemo.employee_profile.controllers;


import com.kahindi.briskspringdemo.employee_profile.records.VehicleRecord;
import com.kahindi.briskspringdemo.employee_profile.services.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"api/v1/vehicles", "api/vehicles"})
@Tag(name = "Vehicle Apis.", description = "Apis to *manage* vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    @Operation(
                    summary = "register vehicle",
                    description = "register service"
    )
    ResponseEntity<Void> registerVehicle(@RequestBody VehicleRecord vehicleRecord) {

        vehicleService.registerVehicle(vehicleRecord);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(
            summary = "get all vehicles",
            description = "get all registered vehicles"
    )
    ResponseEntity<List<VehicleRecord>> getAllVehicles() {
        List<VehicleRecord> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

}
