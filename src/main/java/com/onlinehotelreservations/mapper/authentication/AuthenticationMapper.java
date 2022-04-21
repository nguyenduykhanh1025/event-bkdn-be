package com.onlinehotelreservations.mapper.authentication;

import com.onlinehotelreservations.DTOs.authentication.RegisterDTO;
import com.onlinehotelreservations.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AuthenticationMapper {
    public abstract UserEntity toUserEntity(RegisterDTO registerDTO);
}
