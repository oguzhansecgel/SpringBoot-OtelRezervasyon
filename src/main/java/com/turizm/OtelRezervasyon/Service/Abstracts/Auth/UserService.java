package com.turizm.OtelRezervasyon.Service.Abstracts.Auth;

import com.turizm.OtelRezervasyon.Entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    void add(User user);

    Optional<User> getUserById(int id);
}