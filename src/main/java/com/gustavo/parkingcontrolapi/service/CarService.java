package com.gustavo.parkingcontrolapi.service;

import com.gustavo.parkingcontrolapi.model.CarModel;
import com.gustavo.parkingcontrolapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public CarModel save(CarModel carModel){
        return carRepository.save(carModel);
    }
    public void delete(UUID id){
        carRepository.deleteById(id);
    }
}




