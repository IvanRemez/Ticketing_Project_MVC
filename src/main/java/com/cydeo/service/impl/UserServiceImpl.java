package com.cydeo.service.impl;

import com.cydeo.DTO.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {


    @Override
    public UserDTO save(UserDTO user) {
        return super.save(user.getUsername(), user);
    }

    @Override
    public UserDTO findById(String username) {
        return super.findById(username);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String username) {
        super.deleteById(username);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUsername(), object);
    }

    @Override
    public List<UserDTO> findManagers() {
        return findAll().stream()
                .filter(user -> user.getRole().getDescription().equals("Manager"))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findEmployees() {
        return findAll().stream()
                .filter(user -> user.getRole().getDescription().equals("Employee"))
                .collect(Collectors.toList());
//  OR:
//        return findAll().stream().filter(user -> user.getRole().getId() == 3)
//                .collect(Collectors.toList());

    //  IDs: 1 - Admin, 2 - Manager, 3 - Employee
    }
}
