package net.java.test.springbootsearchrestapi.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_menu")
public class SysMenu {

    @Id
    @Column(length = 50)
    @JsonProperty("MENU_ID")
    private String MENU_ID;

    @Column(length = 100)
    @JsonProperty("MENU_NAME")
    private String MENU_NAME;

    @Column(length = 50)
    @JsonProperty("P_MENU_ID")
    private String P_MENU_ID;

    @Column(columnDefinition = "integer default 1")
    @JsonProperty("SEQ_NO")
    private int SEQ_NO;

    @Column(length = 100)
    @JsonProperty("ICON")
    private String ICON;

    @Column(length = 100)
    @JsonProperty("PATH")
    private String PATH;

    @Column(length = 50)
    @JsonProperty("CREATOR")
    private String CREATOR;

    @CreationTimestamp
    @JsonProperty("CREATE_TIME")
    private LocalDateTime CREATE_TIME;

    @Column(length = 50)
    @JsonProperty("UPDATER")
    private String UPDATER;

    @UpdateTimestamp
    @JsonProperty("UPDATE_TIME")
    private LocalDateTime UPDATE_TIME;

    // `MENU_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单代号',
    // `MENU_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
    // `P_MENU_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上层菜单代号',
    // `SEQ_NO` int(11) NULL DEFAULT 1 COMMENT '序号',
    // `ICON` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
    // `PATH` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
    // `CREATOR` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人员',
    // `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    // `UPDATER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人员',
    // `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
    // PRIMARY KEY (`MENU_ID`) USING BTREE
}
