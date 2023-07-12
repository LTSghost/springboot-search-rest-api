package net.java.test.springbootsearchrestapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.java.test.springbootsearchrestapi.entity.SysUser;
import net.java.test.springbootsearchrestapi.repository.SysUserRepository;
import net.java.test.springbootsearchrestapi.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{

    private SysUserRepository sysUserRepository;

    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public List<SysUser> searchSysUsers() {
        List<SysUser> userList = sysUserRepository.searchSysUsers();
        return userList;
    }

    @Override
    public SysUser createSysUser(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }

}
