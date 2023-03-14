package com.cydeo.converter;

import com.cydeo.DTO.UserDTO;
import com.cydeo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@ConfigurationPropertiesBinding
public class UserDTOConverter implements Converter<String, UserDTO> {

    private final UserService userService;

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
    }
}
