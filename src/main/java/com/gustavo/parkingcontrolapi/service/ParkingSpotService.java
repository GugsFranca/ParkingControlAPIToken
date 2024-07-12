package com.gustavo.parkingcontrolapi.service;

import com.gustavo.parkingcontrolapi.model.ParkingSpotModel;
import com.gustavo.parkingcontrolapi.repository.CarRepository;
import com.gustavo.parkingcontrolapi.repository.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    @Autowired
    ParkingSpotRepository spotRepository;
    @Autowired
    CarRepository carRepository;

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return spotRepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return carRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByCarId(UUID id) {
        return carRepository.existsById(id);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return spotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return spotRepository.existsByApartmentAndBlock(apartment, block);
    }

    public Page<ParkingSpotModel> findAll(Pageable pageable) {
        return spotRepository.findAll(pageable);
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return spotRepository.findById(id);
    }

    public void delete(ParkingSpotModel parkingSpotModel) {
        spotRepository.delete(parkingSpotModel);
    }
}
