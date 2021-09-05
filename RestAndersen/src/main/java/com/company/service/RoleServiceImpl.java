package com.company.service;

import com.company.dao.RoleDao;
import com.company.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl {

    @Autowired
    private RoleDao roleDao;

    public Role findByName(String name) {
        return roleDao.findByName(name);
    }
}
