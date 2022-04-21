package com.onlinehotelreservations.repositories;

import com.onlinehotelreservations.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);
}
