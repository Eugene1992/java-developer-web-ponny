package com.cbs.edu.eshop.service;

import com.cbs.edu.eshop.dto.request.UserCreationRequestDto;
import com.cbs.edu.eshop.entity.User;
import com.cbs.edu.eshop.repository.IUserRepository;
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

    public User get(Integer id) {
        return userRepository.get(id);
    }

    public User create(UserCreationRequestDto userDto) {
        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword()
        );

        return userRepository.create(user);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }
}
