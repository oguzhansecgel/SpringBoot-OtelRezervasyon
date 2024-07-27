package com.turizm.OtelRezervasyon.Core.Mapper;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.RegisterRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Auth.UserResponse;
import com.turizm.OtelRezervasyon.Entities.Role;
import com.turizm.OtelRezervasyon.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface AuthMapper {

    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    User userFromRequest(RegisterRequest request);

    @Mapping(target = "roleId", source = "roles", qualifiedByName = "mapRolesToRoleId")
    UserResponse userFromResponse(User user);
    List<UserResponse> usersFromResponse(List<User> users);

    @Named("mapRolesToRoleId")
    default int mapRolesToRoleId(Set<Role> roles) {
        // Implement your logic here. For example, return the ID of the first role if present.
        return roles.isEmpty() ? 0 : roles.iterator().next().getId();
    }
}