package com.danpung2.trackboardserver.user.domain.service;

import com.danpung2.trackboardserver.user.domain.model.User;
import com.danpung2.trackboardserver.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
