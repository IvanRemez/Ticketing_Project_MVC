package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean userConfirmed;
    private String phone;
    private Role role;
    private Gender gender;

    public User(Long id, LocalDateTime createdDateTime, Long createdUserId, LocalDateTime lastUpdatedDateTime,
                Long lastUpdatedUserId, String firstName, String lastName, String username, String password,
                boolean userConfirmed, String phone, Role role, Gender gender) {
        super(id, createdDateTime, createdUserId, lastUpdatedDateTime, lastUpdatedUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userConfirmed = userConfirmed;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
    }
}
