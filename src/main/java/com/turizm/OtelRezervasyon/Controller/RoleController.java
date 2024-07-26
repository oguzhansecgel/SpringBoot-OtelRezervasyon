package com.turizm.OtelRezervasyon.Controller;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.RoleRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Auth.RoleWithUserResponse;
import com.turizm.OtelRezervasyon.Entities.Role;
import com.turizm.OtelRezervasyon.Entities.User;
import com.turizm.OtelRezervasyon.Service.Abstracts.Auth.RoleService;
import com.turizm.OtelRezervasyon.Service.Abstracts.Auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final UserService userService;

    @PostMapping("/createRoles")
    public ResponseEntity<Role> addRole(@RequestBody RoleRequest role) {
        Role newRole = roleService.addRole(role);
        return ResponseEntity.ok(newRole);
    }
    @PostMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<RoleWithUserResponse> assignRoleToUser(@PathVariable int userId, @PathVariable int roleId) {
        Optional<User> userOptional = userService.getUserById(userId);
        Optional<Role> roleOptional = roleService.getRoleById(roleId);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            User user = userOptional.get();
            Role role = roleOptional.get();

            user.getRoles().add(role);
            userService.add(user);

            RoleWithUserResponse roleWithUserResponse = new RoleWithUserResponse(userId, roleId);
            return ResponseEntity.ok(roleWithUserResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}