package com.cydeo.service.impl;

import com.cydeo.DTO.RoleDTO;
import com.cydeo.service.RoleService;

import java.util.List;

public class RoleServiceImpl extends AbstractMapService<RoleDTO, Long> implements RoleService {

    @Override
    public RoleDTO save(RoleDTO role) {
        return super.save(role.getId(), role);
    }

    @Override
    public RoleDTO findById(Long username) {
        return super.findById(username);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long username) {
        super.deleteById(username);
    }
}
