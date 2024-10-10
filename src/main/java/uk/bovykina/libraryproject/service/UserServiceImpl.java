package uk.bovykina.libraryproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uk.bovykina.libraryproject.dto.CreateUserDto;
import uk.bovykina.libraryproject.dto.UpdateUserDto;
import uk.bovykina.libraryproject.dto.UserResponseDto;
import uk.bovykina.libraryproject.exceptions.UserNotFoundException;
import uk.bovykina.libraryproject.model.User;
import uk.bovykina.libraryproject.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return convertEntityToDto(user);
    }

    @Override
    public UserResponseDto createUser(CreateUserDto createUserDto) {
        User user = userRepository.save(convertCreateDtoToEntity(createUserDto));
        return convertEntityToDto(user);
    }

    @Override
    public UserResponseDto updateUser(UpdateUserDto updateUserDto) {
        User user = userRepository.findById(updateUserDto.getId())
                .orElseThrow(() -> new UserNotFoundException(updateUserDto.getId()));
        
        user.setUsername(updateUserDto.getUsername());
        user.setPassword(updateUserDto.getPassword());
        user.setRole(updateUserDto.getRole());

        userRepository.save(user); 
        return convertEntityToDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private User convertCreateDtoToEntity(CreateUserDto createUserDto) {
        return User.builder()
                .username(createUserDto.getUsername())
                .password(createUserDto.getPassword())
                .role(createUserDto.getRole())
                .build();
    }

    private User convertUpdateDtoToEntity(UpdateUserDto updateUserDto) {
        return User.builder()
                .id(updateUserDto.getId())
                .username(updateUserDto.getUsername())
                .password(updateUserDto.getPassword())
                .role(updateUserDto.getRole())
                .build();
    }

    private UserResponseDto convertEntityToDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
}
