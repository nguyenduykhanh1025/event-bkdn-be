package com.onlinehotelreservations.config;

import com.onlinehotelreservations.entities.RoleEntity;
import com.onlinehotelreservations.entities.UserEntity;
import com.onlinehotelreservations.repositories.RoleRepository;
import com.onlinehotelreservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userOpt = userRepository.findByEmail(username);

        if (userOpt.isPresent()) {

            UserEntity userEntity = userOpt.get();

            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

            Optional<RoleEntity> roleEntityOpt = roleRepository.findById(userEntity.getRoleId());
            RoleEntity roleEntity = new RoleEntity();
            if (roleEntityOpt.isPresent()) {
                roleEntity = roleEntityOpt.get();
            }
            grantedAuthorities.add(new SimpleGrantedAuthority(roleEntity.getName()));

            return new org.springframework.security.core.userdetails.User(
                    userEntity.getEmail(), userEntity.getPassword(), grantedAuthorities);

        }

        throw new UsernameNotFoundException("User not found");
    }
}
