package com.turizm.OtelRezervasyon.Service.Concretes.Auth;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.LoginRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.RegisterRequest;
import com.turizm.OtelRezervasyon.Core.Mapper.AuthMapper;
import com.turizm.OtelRezervasyon.Entities.User;
import com.turizm.OtelRezervasyon.Service.Abstracts.Auth.AuthService;
import com.turizm.OtelRezervasyon.Service.Abstracts.Auth.UserService;
import com.turkcell.tcell.core.security.BaseJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final BaseJwtService baseJwtService;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, UserService userService, AuthenticationManager authenticationManager, BaseJwtService baseJwtService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.baseJwtService = baseJwtService;
    }

    @Override
    public void register(RegisterRequest request) {

        User user = AuthMapper.INSTANCE.userFromRequest(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userService.add(user);

    }

    @Override
    public String login(LoginRequest loginRequest) {
        // TODO: Handle Exception.
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        if(!authentication.isAuthenticated())
            throw new BaseBusinessException("E-posta ya da şifre yanlış");

        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        // TODO: Refactor
        Map<String,Object> claims = new HashMap<>();
        List<String> roles = user
                .getAuthorities()
                .stream()
                .map((role) -> role.getAuthority())
                .toList();
        claims.put("roles", roles);
        return baseJwtService.generateToken(loginRequest.getEmail(), claims);
    }


}
