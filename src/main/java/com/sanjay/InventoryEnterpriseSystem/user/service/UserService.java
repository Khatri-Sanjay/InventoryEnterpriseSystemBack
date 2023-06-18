package com.sanjay.InventoryEnterpriseSystem.user.service;

import com.sanjay.InventoryEnterpriseSystem.user.dto.*;
import org.springframework.stereotype.Service;


public interface UserService {
    UserResponseDto saveUser(UserDto userDto);

    UserResponseListDto getUsers();

    UserResponseDto updateUser(long id, UserDto userDto);

    UserResponseDto findByUserId(long id);

    UserResponseDto deleteUserById(long id) throws Exception;

    LoginResponseDto login(LoginRequestDto request);

    LogoutResponseDto logout(LogoutRequestDto logoutRequestDto);
}
