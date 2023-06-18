package com.sanjay.InventoryEnterpriseSystem.user.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
