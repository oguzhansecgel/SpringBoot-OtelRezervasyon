package com.turizm.OtelRezervasyon.Service.Concretes.Auth;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.RoleRequest;
import com.turizm.OtelRezervasyon.Core.Mapper.RoleMapper;
import com.turizm.OtelRezervasyon.Entities.Role;
import com.turizm.OtelRezervasyon.Repositories.RoleRepository;
import com.turizm.OtelRezervasyon.Service.Abstracts.Auth.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role addRole(RoleRequest request) {
        Role role = RoleMapper.INSTANCE.roleFromRequest(request);
        System.out.println("Mapped Role Name: " + role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(int id) {
    }

    @Override
    public Optional<Role> getRoleById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return List.of();
    }
}