package com.olp.service.impl;

import com.olp.dto.UserDTO;
import com.olp.entity.User;
import com.olp.exception.ResourceNotFoundException;
import com.olp.repository.UserRepository;
import com.olp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
        return mapToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO, String password) {
        // DTO → Entity
        User user = mapToEntity(userDTO);
        user.setPassword(password); // ⚠️ In real apps, hash this password

        // Save to DB
        User savedUser = userRepository.save(user);

        // Entity → DTO
        return mapToDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }

    // 🔹 Manual mapping: DTO → Entity
    private User mapToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setBio(dto.getBio());
        user.setProfilePictureUrl(dto.getProfilePictureUrl());
        user.setContactNumber(dto.getContactNumber()); // ✅ storing contact number
        return user;
    }

    // 🔹 Manual mapping: Entity → DTO
    private UserDTO mapToDTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());
        dto.setBio(entity.getBio());
        dto.setProfilePictureUrl(entity.getProfilePictureUrl());
        dto.setContactNumber(entity.getContactNumber()); // ✅ retrieving contact number
        return dto;
    }
}
