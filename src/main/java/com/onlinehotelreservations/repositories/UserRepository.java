package com.onlinehotelreservations.repositories;

import com.onlinehotelreservations.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);

    @Query(value = "SELECT * FROM users\n" +
            "where email like CONCAT('%', :keyword , '%')\n" +
            "or first_name like CONCAT('%', :keyword ,'%')\n" +
            "or last_name like CONCAT('%', :keyword ,'%')\n", nativeQuery = true)
    List<UserEntity> findUsersByKeyword(@Param("keyword") String keyword);
}
