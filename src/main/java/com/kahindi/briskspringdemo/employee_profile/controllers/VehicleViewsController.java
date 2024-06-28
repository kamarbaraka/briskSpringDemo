package com.kahindi.briskspringdemo.employee_profile.controllers;


import com.kahindi.briskspringdemo.employee_profile.records.VehicleRecord;
import com.kahindi.briskspringdemo.employee_profile.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = {"home/vehicles"})
@RequiredArgsConstructor
public class VehicleViewsController {

    private final VehicleService vehicleService;

    @GetMapping
    String displayAllVehiclesPage(Model model) {

        List<VehicleRecord> allVehicles = vehicleService.getAllVehicles();

        model.addAttribute("vehicles", allVehicles);

        return "home";
    }
}
