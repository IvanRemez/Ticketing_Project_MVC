package com.cydeo.DTO;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean userConfirmed;
    private String phone;
    private RoleDTO role;
    private Gender gender;

}
