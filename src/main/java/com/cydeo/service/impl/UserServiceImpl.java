package com.cydeo.service.impl;

import com.cydeo.DTO.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
