package com.danpung2.trackboardserver.constant.code;

public enum MemberRole {
    OWNER("OWNER", "MR001"),
    MANAGER("MANAGER", "MR002"),
    MEMBER("MEMBER", "MR003"),
    GUEST("GUEST", "MR004");

    private final String role;
    private final String code;

    MemberRole(String role, String code) {
        this.role = role;
        this.code = code;
    }

    public static MemberRole from(String s) {
        return MemberRole.valueOf(s);
    }
}
