package com.cbs.edu.jpa.examples.relationships;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
@Data
public class UserDetails extends AbstractEntity {
    private String nickname;

    @OneToOne(mappedBy = "userDetails")
    private User user;

    @Override
    public String toString() {
        return "UserDetails{" +
                "nickname='" + nickname + '\'' +
                ", user=" + user.getUsername() +
                '}';
    }
}
