package com.kahindi.briskspringdemo.employee_profile.repositories;


import com.kahindi.briskspringdemo.employee_profile.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The VehicleRepository interface provides database operations for the VehicleEntity class.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
}
