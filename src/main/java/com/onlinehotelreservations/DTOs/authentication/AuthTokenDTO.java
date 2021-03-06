package com.onlinehotelreservations.DTOs.authentication;

import com.onlinehotelreservations.controller.user.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenDTO {

    private UserDTO userDTO;

    private String token;
}
