package com.danpung2.trackboardserver.user.domain;

import com.danpung2.trackboardserver.constant.code.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private int id;
    private String nickname;
    private String email;
    private UserRole userRole;

    public User(String nickname, String email, UserRole userRole) {
        this.nickname = nickname;
        this.email = email;
        this.userRole = userRole;
    }
}
