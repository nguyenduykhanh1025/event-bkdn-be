package com.onlinehotelreservations.controller;

import com.onlinehotelreservations.DTOs.authentication.AuthTokenDTO;
import com.onlinehotelreservations.DTOs.authentication.LoginDTO;
import com.onlinehotelreservations.config.TokenProvider;
import com.onlinehotelreservations.controller.user.UserMapper;
import com.onlinehotelreservations.exceptions.authentication.PasswordLoginFailedException;
import com.onlinehotelreservations.mapper.authentication.AuthenticationMapper;
import com.onlinehotelreservations.services.AuthService;
import com.onlinehotelreservations.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider jwtTokenUtil;
    private final UserMapper userMapper;
    private final UserService userService;
    private final AuthService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthTokenDTO> login(@RequestBody @Validated LoginDTO login) {
        if (this.authenticationService.isHandleEmail(login.getEmail()) &&
                this.authenticationService.isHandleStatus(login.getEmail())) {
            try {
                final Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                login.getEmail(),
                                login.getPassword()
                        )
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                final String token = jwtTokenUtil.generateToken(authentication);
                return new ResponseEntity<AuthTokenDTO>(new AuthTokenDTO(this.userMapper.toUserDTO(this.userService.getUserByEmail(login.getEmail())), token), HttpStatus.OK);
            } catch (Exception e) {
                throw new PasswordLoginFailedException();
            }
        }
        throw new UsernameNotFoundException("Login failed");
    }

    @PostMapping("/register-participant")
    public ResponseEntity<AuthTokenDTO> registerParticipant(@RequestBody @Validated LoginDTO login) {
        return null;
    }
}
