package com.cbs.edu.eshop.entity;

public enum RoleEnum {
    USER(new Role(0, "USER")),
    ADMIN(new Role(1, "ADMIN"));

    private Role role;

    RoleEnum(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
