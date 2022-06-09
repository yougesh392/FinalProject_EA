package edu.miu.cs544.authenticationservice.service.impl;

import edu.miu.cs544.authenticationservice.model.LoginRequest;
import edu.miu.cs544.authenticationservice.model.LoginResponse;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest) throws Exception;
}
