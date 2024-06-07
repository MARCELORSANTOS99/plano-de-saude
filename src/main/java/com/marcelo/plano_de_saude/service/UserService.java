package com.marcelo.plano_de_saude.service;

import org.springframework.stereotype.Service;

import com.marcelo.plano_de_saude.entity.User;
import com.marcelo.plano_de_saude.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}
