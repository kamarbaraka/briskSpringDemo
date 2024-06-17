package com.kahindi.briskspringdemo.employee_profile.services;

import com.kahindi.briskspringdemo.Vehicle;
import com.kahindi.briskspringdemo.VehicleID;
import com.kahindi.briskspringdemo.VehicleServiceGrpc.VehicleServiceImplBase;
import com.kahindi.briskspringdemo.employee_profile.entities.VehicleEntity;
import com.kahindi.briskspringdemo.employee_profile.repositories.VehicleRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;


/**
 *
 */
@GrpcService
@RequiredArgsConstructor
public class VehicleServiceGrpcImpl extends VehicleServiceImplBase {

    private final VehicleRepository repository;

    @Override
    public void registerVehicle(Vehicle request, StreamObserver<VehicleID> responseObserver) {

        VehicleEntity vehicleEntity = VehicleEntity.builder()
                .name(request.getName())
                .model(request.getModel())
                .build();

        repository.save(vehicleEntity);

        VehicleID response = VehicleID.newBuilder()
                .setId(Long.toString(vehicleEntity.getVehicleID()))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void findVehicleByID(VehicleID request, StreamObserver<Vehicle> responseObserver) {

        VehicleEntity vehicleEntity = repository.findById(
                Long.parseLong(request.getId())
        ).orElseThrow();

        Vehicle response = Vehicle.newBuilder()
                .setId(Long.toString(vehicleEntity.getVehicleID()))
                .setName(vehicleEntity.getName())
                .setModel(vehicleEntity.getModel())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
