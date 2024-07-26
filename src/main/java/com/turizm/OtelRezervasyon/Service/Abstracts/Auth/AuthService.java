package com.turizm.OtelRezervasyon.Service.Abstracts.Auth;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.LoginRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.RegisterRequest;

public interface AuthService {

    void register(RegisterRequest request);

    String login(LoginRequest loginRequest);
}