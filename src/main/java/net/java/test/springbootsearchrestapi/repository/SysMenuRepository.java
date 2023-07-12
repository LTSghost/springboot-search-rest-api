package net.java.test.springbootsearchrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.java.test.springbootsearchrestapi.entity.SysMenu;

public interface SysMenuRepository extends JpaRepository<SysMenu, String>{

    @Query(value = "SELECT * FROM sys_menu", nativeQuery = true)
    List<SysMenu> readSysMenu();

}
