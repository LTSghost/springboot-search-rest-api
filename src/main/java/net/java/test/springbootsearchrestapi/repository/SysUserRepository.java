package net.java.test.springbootsearchrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.java.test.springbootsearchrestapi.entity.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, String>{

    @Query(value = "SELECT * FROM sys_user", nativeQuery = true)
    List<SysUser> searchSysUsers();

}
