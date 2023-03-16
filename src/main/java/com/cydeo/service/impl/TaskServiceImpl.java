package com.cydeo.service.impl;

import com.cydeo.DTO.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO task) {

        if (task.getTaskStatus() == null) {
            task.setTaskStatus(Status.OPEN);
        }// sets Status of New Task since there is no input field for it

        if (task.getAssignedDate() == null) {
            task.setAssignedDate(LocalDate.now());
        }// sets assignedDate of New Task since there is no input field for it

        if (task.getId() == null) {
            task.setId(UUID.randomUUID().getMostSignificantBits());
        }// sets ID of New Task since there is no input field for it

        return super.save(task.getId(), task);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(TaskDTO task) {

        if (task.getTaskStatus() == null) {
            task.setTaskStatus(findById(task.getId()).getTaskStatus());
        }// captures status of Project being updated and sets it again prior to saving in DB
        // Also needed b/c there is no input Status field in form

        if (task.getAssignedDate() == null) {
            task.setAssignedDate(findById(task.getId()).getAssignedDate());
        }// captures assignedDate of Task being updated and sets it again prior to saving in DB
        // Also needed b/c there is no input assignedDate field in form

        super.update(task.getId(), task);
    }
}
