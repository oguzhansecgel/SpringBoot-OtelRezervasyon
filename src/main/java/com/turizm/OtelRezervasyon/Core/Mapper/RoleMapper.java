package com.turizm.OtelRezervasyon.Core.Mapper;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Auth.RoleRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Auth.RoleWithUserResponse;
import com.turizm.OtelRezervasyon.Entities.Role;
import com.turizm.OtelRezervasyon.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role roleFromRequest(RoleRequest request);

    @Mapping(source = "roleId", target = "id")
    Role toRole(RoleWithUserResponse roleWithUserResponse);

    @Mapping(source = "userId", target = "id")
    User toUser(RoleWithUserResponse roleWithUserResponse);
}