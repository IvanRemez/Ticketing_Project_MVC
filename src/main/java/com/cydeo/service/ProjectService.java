package com.cydeo.service;

import com.cydeo.DTO.ProjectDTO;
import com.cydeo.DTO.UserDTO;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO, String> {

    void complete(ProjectDTO project);

    List<ProjectDTO> getCounterListOfProjectDTO(UserDTO manager);

}
