package com.gustavo.parkingcontrolapi.DTO;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO (@NotBlank String token){
}
