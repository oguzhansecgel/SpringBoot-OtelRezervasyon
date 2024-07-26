package com.turizm.OtelRezervasyon.Service.Abstracts.Auth;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.RoleRequest;
import com.turizm.OtelRezervasyon.Entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role addRole(RoleRequest request);

    void deleteRole(int id);

    Optional<Role> getRoleById(int id);

    List<Role> getAllRoles();
}