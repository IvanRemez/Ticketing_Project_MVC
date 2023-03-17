package com.cydeo.service;

import com.cydeo.DTO.TaskDTO;
import com.cydeo.DTO.UserDTO;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long> {

    List<TaskDTO> findTasksByManager(UserDTO manager);
}
