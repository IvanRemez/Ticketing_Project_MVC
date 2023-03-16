package com.cydeo.converter;

import com.cydeo.DTO.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationPropertiesBinding - done automatically by latest version of Spring
public class UserDTOConverter implements Converter<String, UserDTO> {

    private final UserService userService;

    public UserDTOConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
    }
}
