package net.java.test.springbootsearchrestapi.service;

import java.util.List;

import net.java.test.springbootsearchrestapi.entity.SysRole;

public interface SysRoleService {
    List<SysRole> searchSysRoles(String query);

    SysRole createSysRole(SysRole sysRole);
}
