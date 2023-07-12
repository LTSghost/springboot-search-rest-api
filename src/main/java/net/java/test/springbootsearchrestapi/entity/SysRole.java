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
@Table(name = "sysrole")
public class SysRole {

    @Id
    @Column(length = 50, unique = true)
    @JsonProperty("ROLE_ID")
    private String ROLE_ID; 

    @Column(length = 100)
    @JsonProperty("ROLE_NAME")
    private String ROLE_NAME;

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
    
}
