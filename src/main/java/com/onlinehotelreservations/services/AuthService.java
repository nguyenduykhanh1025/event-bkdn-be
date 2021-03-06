package com.onlinehotelreservations.services;

import com.onlinehotelreservations.entities.UserEntity;
import com.onlinehotelreservations.exceptions.authentication.EmailLoginFailedException;
import com.onlinehotelreservations.exceptions.authentication.InActiveStatusUserException;
import com.onlinehotelreservations.repositories.UserRepository;
import com.onlinehotelreservations.shared.enums.UserStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;

    public boolean isHandleEmail(String email) {
        Optional<UserEntity> userEntity = this.userRepository.findByEmail(email);
        if (!userEntity.isPresent()) {
            throw new EmailLoginFailedException();
        }
        return true;
    }

    public boolean isHandleStatus(String email) {
        Optional<UserEntity> userEntity = this.userRepository.findByEmail(email);
        if (userEntity.isPresent()) {
            if (userEntity.get().getStatus().equals(UserStatus.INACTIVE)) {
                throw new InActiveStatusUserException(email);
            }
        }
        return true;
    }
}
