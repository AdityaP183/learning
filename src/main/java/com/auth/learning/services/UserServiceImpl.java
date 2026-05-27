package com.auth.learning.services;

import com.auth.learning.dtos.UserDto;
import com.auth.learning.entities.Provider;
import com.auth.learning.entities.UserEntity;
import com.auth.learning.exceptions.ResourceNotFoundException;
import com.auth.learning.helpers.UserHelper;
import com.auth.learning.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        if (userDto.getEmail() == null || userDto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        UserEntity user = modelMapper.map(userDto, UserEntity.class);
        user.setProvider(userDto.getProvider() != null ? userDto.getProvider() : Provider.LOCAL);
//        TODO: assign role to new user
        UserEntity savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    @Transactional
    public Iterable<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(
                user -> modelMapper.map(user, UserDto.class)
        ).toList();
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserEntity user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given email id"));

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserById(String userId) {
        UUID userUUID = UserHelper.parseUUID(userId);

        UserEntity user = userRepository
                .findById(userUUID)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given email id"));

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        UUID userUUID = UserHelper.parseUUID(userId);

        UserEntity exitingUser = userRepository
                .findById(userUUID)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given email id"));

        if (userDto.getName() != null) exitingUser.setName(userDto.getName());
        if (userDto.getImage() != null) exitingUser.setImage(userDto.getImage());
        if (userDto.getProvider() != null) exitingUser.setProvider(userDto.getProvider());
        /*TODO: add password hashing*/
        if (userDto.getPassword() != null) exitingUser.setPassword(userDto.getPassword());
        userDto.setVerified(userDto.isVerified());

        UserEntity updatedUser = userRepository.save(exitingUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    @Transactional
    public void deleteUser(String userId) {
        UUID userUUID = UserHelper.parseUUID(userId);

        UserEntity user = userRepository
                .findById(userUUID)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given email id"));

        userRepository.delete(user);
    }
}
