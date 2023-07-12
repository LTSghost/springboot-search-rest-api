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
@Table(name = "sys_user")
public class SysUser {

    @Id
    @Column(length = 50, unique = true)
    @JsonProperty("USER_ID")
    private String USER_ID;

    @Column(length = 100)
    @JsonProperty("USER_NAME")
    private String USER_NAME;

    @Column(length = 100)
    @JsonProperty("PASSWORD")
    private String PASSWORD;
    // String sha256hex = DigestUtils.sha256Hex(originalString);

    @JsonProperty("IS_VALID")
    private Character IS_VALID;

    @Column(length = 50)
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

}
