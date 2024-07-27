package com.turizm.OtelRezervasyon.Service.Concretes.Auth;

import com.turizm.OtelRezervasyon.Core.Dto.Response.Auth.UserResponse;
import com.turizm.OtelRezervasyon.Core.Mapper.AuthMapper;
import com.turizm.OtelRezervasyon.Entities.User;
import com.turizm.OtelRezervasyon.Repositories.UserRepository;
import com.turizm.OtelRezervasyon.Service.Abstracts.Auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public void add(User user) {
     /*   Optional<User> hasEmail = userRepository.findByEmail(user.getEmail());
        if (hasEmail.isPresent())
        {
            throw new BaseBusinessException("User already exists");
        }*/
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> userResponse = userRepository.findAll();
        return AuthMapper.INSTANCE.usersFromResponse(userResponse);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BaseBusinessException("User not found with email or password "));
    }
}