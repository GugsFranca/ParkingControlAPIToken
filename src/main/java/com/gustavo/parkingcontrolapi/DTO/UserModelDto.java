package com.gustavo.parkingcontrolapi.DTO;

import com.gustavo.parkingcontrolapi.model.RoleModel;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.gustavo.parkingcontrolapi.model.UserModel}
 */
public record UserModelDto( String username,String password,List<RoleModel> roleModels) implements Serializable {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "roleModels = " + roleModels + ")";
    }

    @Override
    public String username() {
        return username;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public List<RoleModel> roleModels() {
        return roleModels;
    }
}