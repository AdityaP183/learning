package com.auth.learning.services;

import com.auth.learning.dtos.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

    Iterable<UserDto> getAllUsers();

    UserDto getUserByEmail(String email);

    UserDto getUserById(String userId);

    UserDto updateUser(UserDto userDto, String userId);

    void deleteUser(String userId);
}
