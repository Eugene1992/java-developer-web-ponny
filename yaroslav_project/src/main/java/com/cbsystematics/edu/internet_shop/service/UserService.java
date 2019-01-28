package com.cbsystematics.edu.internet_shop.service;

import com.cbsystematics.edu.internet_shop.dto.request.UserCreationRequestDto;
import com.cbsystematics.edu.internet_shop.entity.User;
import com.cbsystematics.edu.internet_shop.entity.UserDetails;
import com.cbsystematics.edu.internet_shop.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByUsernameAndPassword(String username, String password) {
        return null;
    }

    public User get(Integer id) {
        return userRepository.get(id);
    }

    public User create(UserCreationRequestDto userDto) {
        UserDetails userDetails = new UserDetails(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPhone()
        );
        User user = new User(
                userDto.getUsername(),
                userDto.getPassword()
        );
        user.setUserDetails(userDetails);
        return userRepository.create(user);
    }

    public User update(UserCreationRequestDto userDto) {
        UserDetails userDetails = new UserDetails(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPhone()
        );
        User user = new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword()
        );
        user.setUserDetails(userDetails);
        return userRepository.update(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }
}
