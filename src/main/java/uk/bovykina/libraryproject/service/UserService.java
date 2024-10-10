package uk.bovykina.libraryproject.service;

import java.util.List;

import uk.bovykina.libraryproject.dto.CreateUserDto;
import uk.bovykina.libraryproject.dto.UpdateUserDto;
import uk.bovykina.libraryproject.dto.UserResponseDto;

public interface UserService {

    UserResponseDto getUserById(Long id);

    UserResponseDto createUser(CreateUserDto userDto);

    UserResponseDto updateUser(UpdateUserDto userDto);

    void deleteUser(Long id);

    List<UserResponseDto> getAllUsers();
}
