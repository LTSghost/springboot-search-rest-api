package net.java.test.springbootsearchrestapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import jakarta.annotation.Resource;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import net.java.test.springbootsearchrestapi.entity.SysUser;
import net.java.test.springbootsearchrestapi.repository.SysUserRepository;
import net.java.test.springbootsearchrestapi.service.SysUserService;

@Slf4j //log
@RestController
@RequestMapping("api/v1/sys_user")
@CrossOrigin(origins="*")
public class SysUserController {
    
    @Resource
    private SysUserService sysUserService;

    private SysUserRepository sysUserRepository;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping("/list")
    public ResponseEntity<List<SysUser>> searchSysUsers() {
        
        // void
        // System.out.println(sysUserRepository.findAll());
        // return;

        System.out.println("=================list======");

        // System.out.println(sysUserRepository.findById("admin"));

        return ResponseEntity.ok(sysUserService.searchSysUsers());
    }

    // @PostMapping(value = "/add")
    // public String addUser(SysUser sysUser) {
    //     sysUserRepository.save(sysUser);
    //     System.out.println(sysUser);
    //     return "add success";
    // }

    @PostMapping
    public SysUser creatUser(@RequestBody SysUser sysUser){
        return sysUserService.createSysUser(sysUser);
    }

    @PostMapping("/validate")
    Map<String, Object> validateUser(@RequestBody String requestBody) throws JsonMappingException, JsonProcessingException{
        log.info("===SysUserController.validateUser()===");

        ObjectMapper objectMapper = new ObjectMapper();
        SysUser requestUser = objectMapper.readValue(requestBody, SysUser.class);

        System.out.println(requestUser.getUSER_ID());

        List<SysUser> sysUserList = sysUserService.searchSysUsers();

        Map<String, Object> newMap = new HashMap<>();

        for (SysUser element : sysUserList) {
            System.out.println(element.getUSER_ID());
            System.out.println(requestUser.getUSER_ID());
            if (Objects.equals(element.getUSER_ID(), requestUser.getUSER_ID())) {
                if ("quasar".equals(requestUser.getPASSWORD())) {
                    newMap.put("MessageId", "LoginSuccess");
                    newMap.put("Message", "登入成功");
                    newMap.put("Status", "Y");
                    newMap.put("User", element);
                    break;
                }
                newMap.put("MessageId", "LoginError");
                newMap.put("Message", "密碼錯誤");
                newMap.put("Status", "N");
                newMap.put("User", null);
                break;
            } else {
                newMap.put("MessageId", "LoginError");
                newMap.put("Message", "查無此帳號");
                newMap.put("Status", "N");
                newMap.put("User", null);
            }
        }
    
        return newMap;

    }

}
