package com.gustavo.parkingcontrolapi.repository;

import com.gustavo.parkingcontrolapi.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<CarModel, UUID> {
    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsById(UUID id);

}
