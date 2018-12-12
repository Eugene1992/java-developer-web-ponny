package jdbc.homework1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
//@Entity

public class User extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;

    public User(Integer id, String firstName, String lastName, String userName, String password, String email) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }


}
