package com.cydeo.converter;

import com.cydeo.DTO.ProjectDTO;
import com.cydeo.service.ProjectService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationPropertiesBinding - done automatically by latest version of Spring
public class ProjectDTOConverter implements Converter<String, ProjectDTO> {

    private final ProjectService projectService;

    public ProjectDTOConverter(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String source) {
        return projectService.findById(source);
    }
}
