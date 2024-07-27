package com.turizm.OtelRezervasyon.Controller;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.LoginRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.RegisterRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Auth.UserResponse;
import com.turizm.OtelRezervasyon.Service.Abstracts.Auth.AuthService;
import com.turizm.OtelRezervasyon.Service.Abstracts.Auth.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RoleService roleService;

    @PostMapping("register")
    public void register( @RequestBody RegisterRequest request)
    {
        authService.register(request);
    }

    @PostMapping("login")
    public String login( @RequestBody LoginRequest request)
    {
        return authService.login(request);
    }
}