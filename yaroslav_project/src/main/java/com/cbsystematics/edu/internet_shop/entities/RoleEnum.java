package com.cbsystematics.edu.internet_shop.entities;

public enum RoleEnum {
    USER(new Role("User")),
    ADMIN(new Role("Admin")),
    MODERATOR(new Role("Moderator"));

    private Role role;

    RoleEnum(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
