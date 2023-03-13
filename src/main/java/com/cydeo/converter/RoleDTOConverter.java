package com.cydeo.converter;

import com.cydeo.DTO.RoleDTO;
import com.cydeo.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@ConfigurationPropertiesBinding
// ^^ lets Spring know where to go for any Config. actions needed by objects (Converting values)
public class RoleDTOConverter implements Converter<String, RoleDTO> {

    private final RoleService roleService;

    @Override
    public RoleDTO convert(String source) {
        return roleService.findById(Long.parseLong(source));
    }
}
