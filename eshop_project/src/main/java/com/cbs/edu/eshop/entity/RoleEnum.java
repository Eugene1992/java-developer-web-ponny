package com.cbs.edu.eshop.entity;

public enum RoleEnum {
    USER(new Role("USER")),
    ADMIN(new Role("ADMIN"));

    private Role role;

    RoleEnum(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
