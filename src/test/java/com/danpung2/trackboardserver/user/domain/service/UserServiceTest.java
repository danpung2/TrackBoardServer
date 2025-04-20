package com.danpung2.trackboardserver.user.domain.service;

import com.danpung2.trackboardserver.constant.code.UserRole;
import com.danpung2.trackboardserver.user.domain.model.User;
import com.danpung2.trackboardserver.user.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser() {
        // given
        User user = new User("tester", "tester@gmail.com", "FakePassword!@#", UserRole.MEMBER);

        // when
        userService.createUser(user);

        // then
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userCaptor.capture());

        User savedUser = userCaptor.getValue();

        // System.out.println(savedUser);
        // User(id=0, nickname=tester, email=tester@gmail.com, password=FakePassword!@#, userRole=MEMBER)

        assertThat(savedUser.getNickname()).isEqualTo(user.getNickname());
        assertThat(savedUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(savedUser.getUserRole()).isEqualTo(user.getUserRole());
    }
}