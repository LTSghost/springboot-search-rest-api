package net.java.test.springbootsearchrestapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.java.test.springbootsearchrestapi.entity.SysRole;
import net.java.test.springbootsearchrestapi.repository.SysRoleRepository;
import net.java.test.springbootsearchrestapi.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService{

    private SysRoleRepository sysRoleRepository;

    public SysRoleServiceImpl(SysRoleRepository sysRoleRepository) {
        this.sysRoleRepository = sysRoleRepository;
    }

    @Override
    public List<SysRole> searchSysRoles(String query) {
        // return sysRoleRepository.searchSysRoles(query);
        List<SysRole> sysrole = sysRoleRepository.searchSysRoles(query);
        return sysrole;
    }

    @Override
    public SysRole createSysRole(SysRole sysRole) {
        return sysRoleRepository.save(sysRole);
    }

}
