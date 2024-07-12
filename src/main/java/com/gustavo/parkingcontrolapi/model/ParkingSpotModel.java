package com.gustavo.parkingcontrolapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ParkingSpotModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false, length = 130)
    private String responsibleName;
    @Column(nullable = false, length = 30)
    private String apartment;
    @Column(nullable = false, length = 30)
    private String block;
    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarModel carModel;

    @JsonCreator
    public ParkingSpotModel(@JsonProperty("id") UUID id,
                            @JsonProperty("parkingSpotNumber")String parkingSpotNumber,
                            @JsonProperty("registrationDate")LocalDateTime registrationDate,
                            @JsonProperty("responsibleName")String responsibleName,
                            @JsonProperty("apartment")String apartment,
                            @JsonProperty("block")String block,
                            @JsonProperty("carModel")CarModel carModel) {
        this.id = id;
        this.parkingSpotNumber = parkingSpotNumber;
        this.registrationDate = registrationDate;
        this.responsibleName = responsibleName;
        this.apartment = apartment;
        this.block = block;
        this.carModel = carModel;
    }

    public ParkingSpotModel() {

    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingSpotModel that)) return false;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(parkingSpotNumber, that.parkingSpotNumber))
            return false;
        if (!Objects.equals(registrationDate, that.registrationDate))
            return false;
        if (!Objects.equals(responsibleName, that.responsibleName))
            return false;
        if (!Objects.equals(apartment, that.apartment)) return false;
        return Objects.equals(block, that.block);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (parkingSpotNumber != null ? parkingSpotNumber.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (responsibleName != null ? responsibleName.hashCode() : 0);
        result = 31 * result + (apartment != null ? apartment.hashCode() : 0);
        result = 31 * result + (block != null ? block.hashCode() : 0);
        return result;
    }
}
