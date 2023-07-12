package net.java.test.springbootsearchrestapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.java.test.springbootsearchrestapi.entity.SysRole;
import net.java.test.springbootsearchrestapi.service.SysRoleService;

@RestController
@RequestMapping("api/v1/sysrole")
public class SysRoleController {
    
    private SysRoleService sysRoleService;

    private String output = "哭阿";

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @CrossOrigin
    @GetMapping("/search")
    public ResponseEntity<List<SysRole>> searchSysRoles(@RequestParam("query") String query) {
        return ResponseEntity.ok(sysRoleService.searchSysRoles(query));
    }

    @GetMapping("/cry")
    public String searchSysRoles() {
        return output;
    }

    @PostMapping
    public SysRole createSysRole(@RequestBody SysRole sysRole) {
        return sysRoleService.createSysRole(sysRole);
    }

}
