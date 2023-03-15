package com.cydeo.service;

import com.cydeo.DTO.ProjectDTO;

public interface ProjectService extends CrudService<ProjectDTO, String> {

    void complete(ProjectDTO project);
}
