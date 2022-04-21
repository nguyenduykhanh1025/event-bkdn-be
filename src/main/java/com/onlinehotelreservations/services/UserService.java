package com.onlinehotelreservations.services;

import com.onlinehotelreservations.controller.user.exception.UserIsNotExistsException;
import com.onlinehotelreservations.controller.user.exception.UserNotFoundException;
import com.onlinehotelreservations.entities.UserEntity;
import com.onlinehotelreservations.repositories.RoleRepository;
import com.onlinehotelreservations.repositories.UserRepository;
import com.onlinehotelreservations.shared.enums.UserStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public List<UserEntity> getAllUser() {
        return this.userRepository.findAll();
    }

    public UserEntity getUserFollowId(int id) {
        UserEntity userEntity = this.userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id));
        return userEntity;
    }

    public UserEntity getUserByEmail(String email) {
        UserEntity userEntity = this.userRepository.findByEmail(email).orElseThrow(() ->
                new UserNotFoundException(0));
        return userEntity;
    }

    public void deleteUserFollowId(int id) {
        if (!this.userRepository.existsById(id)) {
            throw new UserIsNotExistsException(id);
        }
        this.userRepository.deleteById(id);
    }

    public UserEntity reverseStatusUserFollowId(int id) {
        if (!this.userRepository.existsById(id)) {
            throw new UserIsNotExistsException(id);
        }
        UserEntity userEntity = this.userRepository.findById(id).get();
        userEntity.setStatus(userEntity.getStatus() == UserStatus.ACTIVE ? UserStatus.INACTIVE : UserStatus.ACTIVE);
        this.userRepository.save(userEntity);

        return userEntity;
    }

    public List<UserEntity> searchUsers(String keySearch) {
        List<UserEntity> userEntities = this.userRepository.findUsersByKeyword(keySearch);
        return userEntities;
    }
}
