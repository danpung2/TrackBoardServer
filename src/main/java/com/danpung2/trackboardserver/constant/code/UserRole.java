package com.danpung2.trackboardserver.constant.code;

public enum UserRole {
    ADMIN("ADMIN", "UR001"),
    MEMBER("MEMBER", "UR002");

    private final String role;
    private final String code;

    UserRole(String role, String code) {
        this.role = role;
        this.code = code;
    }

    public static UserRole from(String s) {
        return UserRole.valueOf(s);
    }
}
