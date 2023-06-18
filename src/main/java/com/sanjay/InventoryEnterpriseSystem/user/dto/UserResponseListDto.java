package com.sanjay.InventoryEnterpriseSystem.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseListDto {
    private List<UserResponseDto> users;
    private long total;
}
