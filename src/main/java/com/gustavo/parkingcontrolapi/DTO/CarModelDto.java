package com.gustavo.parkingcontrolapi.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.gustavo.parkingcontrolapi.model.CarModel}
 */
public record CarModelDto(@NotBlank @Size(max = 7) String licensePlateCar, @NotBlank String brandCar,
                          @NotBlank String modelCar, @NotBlank String colorCar) implements Serializable {
    public CarModelDto(String licensePlateCar, String brandCar, String modelCar, String colorCar) {
        this.licensePlateCar = licensePlateCar;
        this.brandCar = brandCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
    }

    @Override
    public String licensePlateCar() {
        return licensePlateCar;
    }

    @Override
    public String brandCar() {
        return brandCar;
    }

    @Override
    public String modelCar() {
        return modelCar;
    }

    @Override
    public String colorCar() {
        return colorCar;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "licensePlateCar = " + licensePlateCar + ", " +
                "brandCar = " + brandCar + ", " +
                "modelCar = " + modelCar + ", " +
                "colorCar = " + colorCar + ")";
    }
}