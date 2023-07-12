package net.java.test.springbootsearchrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.java.test.springbootsearchrestapi.entity.SysRole;

public interface SysRoleRepository extends JpaRepository<SysRole, String>{
    
    @Query("SELECT p FROM SysRole p WHERE " + 
    "p.ROLE_ID LIKE CONCAT('%',:query, '%')" +
    "Or p.ROLE_NAME  LIKE CONCAT('%', :query, '%')")
    List<SysRole> searchSysRoles(String query);

    // @Query(value = "SELECT * FROM sysrole p WHERE " + 
    // "p.name LIKE CONCAT('%',:query, '%')" +
    // "Or p.description LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    // List<SysRole> searchSysRolesSQL(String query);
}
