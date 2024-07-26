package com.turizm.OtelRezervasyon.Core.Dto.Response.Auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleWithUserResponse {

    private int userId;

    private int roleId;
}