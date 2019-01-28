package com.cbs.edu.eshop.service;

import com.cbs.edu.eshop.dto.request.UserCreationRequestDto;
import com.cbs.edu.eshop.entity.Role;
import com.cbs.edu.eshop.entity.User;
import com.cbs.edu.eshop.repository.IRoleRepository;
import com.cbs.edu.eshop.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

    @Autowired
    public UserService(IUserRepository userRepository, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User get(Integer id) {
        return userRepository.get(id);
    }

    @Transactional
    public User create(UserCreationRequestDto userDto) {

        Role role;
        if (!userDto.getUsername().contains("admin")) {
            role = new Role("USER");
        } else {
            role = new Role("ADMIN");
        }

        Role savedRole = roleRepository.create(role);

        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword()
        );

        user.setRole(savedRole);

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

    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }
}
