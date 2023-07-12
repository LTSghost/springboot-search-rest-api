package net.java.test.springbootsearchrestapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.java.test.springbootsearchrestapi.entity.SysMenu;
import net.java.test.springbootsearchrestapi.repository.SysMenuRepository;
import net.java.test.springbootsearchrestapi.service.SysMenuService;

@Slf4j
@Service
public class SysMenuServiceImpl implements SysMenuService{

    private SysMenuRepository sysMenuRepository;

    public SysMenuServiceImpl(SysMenuRepository sysMenuRepository) {
        this.sysMenuRepository = sysMenuRepository;
    }

    @Override
    public List<SysMenu> readSysMenu() {
        log.info("===SysMenuServiceImpl===");

        return sysMenuRepository.readSysMenu();
    }
    
}
