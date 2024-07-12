package com.gustavo.parkingcontrolapi.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.gustavo.parkingcontrolapi.model.ParkingSpotModel}
 */
public record ParkingSpotDto(@NotBlank String parkingSpotNumber, @NotBlank String responsibleName,
                             @NotBlank String apartment, @NotBlank String block,
                             @NotNull CarModelDto carModel) implements Serializable {
    @JsonCreator
    public ParkingSpotDto(@JsonProperty("parkingSpotNumber") String parkingSpotNumber,
                          @JsonProperty("responsibleName") String responsibleName,
                          @JsonProperty("apartment") String apartment,
                          @JsonProperty("block") String block,
                          @JsonProperty("carModel") CarModelDto carModel) {
        this.parkingSpotNumber = parkingSpotNumber;
        this.responsibleName = responsibleName;
        this.apartment = apartment;
        this.block = block;
        this.carModel = carModel;
    }

    @Override
    public String parkingSpotNumber() {
        return parkingSpotNumber;
    }


    @Override
    public String responsibleName() {
        return responsibleName;
    }

    @Override
    public String apartment() {
        return apartment;
    }

    @Override
    public String block() {
        return block;
    }

    @Override
    public CarModelDto carModel() {
        return carModel;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "parkingSpotNumber = " + parkingSpotNumber + ", " +
                "responsibleName = " + responsibleName + ", " +
                "apartment = " + apartment + ", " +
                "block = " + block + ", " +
                "carModel = " + carModel + ")";
    }
}