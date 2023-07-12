package net.java.test.springbootsearchrestapi.service;

import java.util.List;

import net.java.test.springbootsearchrestapi.entity.SysUser;

public interface SysUserService {
    List<SysUser> searchSysUsers();

    SysUser createSysUser(SysUser sysUser);
}
