package com.sanjay.InventoryEnterpriseSystem.user.service;

import com.sanjay.InventoryEnterpriseSystem.user.User;
import com.sanjay.InventoryEnterpriseSystem.user.dto.*;
import com.sanjay.InventoryEnterpriseSystem.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        User user =new User();
        user.setLastName(user.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAddress(userDto.getAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setRole("User");
        user.setPassword(userDto.getPassword());
        User savedUser = userRepository.save(user);
        return getUserResponse(savedUser);
    }

    public UserResponseDto getUserResponse(User user){
        UserResponseDto response = new UserResponseDto();
        response.setId(user.getId());
        System.out.println("Sanjay"+user.getLastModifiedAt());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setAddress(user.getAddress());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setEmail(user.getEmail());
        return response;
    }
    @Override
    public UserResponseListDto getUsers() {
        List<UserResponseDto> userResponseDto =new ArrayList<>();
        List<User>users = userRepository.findAll();

        for(User user: users){
            userResponseDto.add(getUserResponse(user));
        }

        UserResponseListDto response = new UserResponseListDto();
        response.setUsers(userResponseDto);

        response.setTotal(userResponseDto.size());

        return response;
    }

    @Override
    public UserResponseDto updateUser(long id, UserDto userDto) {
        Optional<User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user1=optionalUser.get();
            user1.setFirstName(userDto.getFirstName());
            user1.setLastName(userDto.getLastName());
            user1.setAddress(userDto.getAddress());
            user1.setPhoneNumber(userDto.getPhoneNumber());
            user1.setEmail(userDto.getEmail());

            User savedUser= userRepository.save(user1);
            return getUserResponse(savedUser);

        }

        return null;
    }

    @Override
    public UserResponseDto findByUserId(long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return getUserResponse(user.get());
        }
        else{
            System.out.println("oops user not found!!!");
        }
        return null;
    }

    @Override
    public UserResponseDto deleteUserById(long id) throws Exception{
        Optional<User> user =userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
        }else
        {
            throw new Exception ("oops user cant be deleted!!!");
        }
        return  null;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        LoginResponseDto response = new LoginResponseDto();
        User user = userRepository.findByEmail(request.getEmail());

        if(user == null){
            throw new RuntimeException("User not found!!!");
        }

        boolean checkpswd = user.getPassword().equals(request.getPassword());

        System.out.println("jelllonfov" + checkpswd);

        if(!checkpswd)
            throw new RuntimeException("Password does not match!!");



        user.setLoggedIn(true);
        userRepository.save(user);

        response.setUserId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }

    @Override
    public LogoutResponseDto logout(LogoutRequestDto logoutRequestDto) {
        User user = userRepository.findByEmail(logoutRequestDto.getEmail());

        LogoutResponseDto response= new LogoutResponseDto();

        if(user ==null)
            response.setMessage("User do not exist!!!");

        user.setLoggedIn(false);
        userRepository.save(user);
        return response;
    }
}
