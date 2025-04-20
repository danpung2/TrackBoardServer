package com.danpung2.trackboardserver.user.domain.entity;

import com.danpung2.trackboardserver.constant.code.UserRole;
import com.danpung2.trackboardserver.user.domain.model.User;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public UserEntity(String nickname, String email, String password, UserRole userRole) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User toModel() {
        return new User(id, nickname, email, password, userRole);
    }

    public static UserEntity fromModel(User user) {
        return new UserEntity(user.getNickname(), user.getEmail(), user.getPassword(), user.getUserRole());
    }
}
