package edu.miu.cs544.authenticationservice.service.impl;

import edu.miu.cs544.authenticationservice.model.LoginRequest;
import edu.miu.cs544.authenticationservice.model.LoginResponse;
import edu.miu.cs544.authenticationservice.repository.UserRepository;
import edu.miu.cs544.authenticationservice.security.Jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UaaServiceImpl implements UaaService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception(e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails, userRepository.findByEmail(loginRequest.getEmail()).get());
        return new LoginResponse(jwt);
    }
}
