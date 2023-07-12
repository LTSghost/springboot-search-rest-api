package net.java.test.springbootsearchrestapi.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
@Table(name = "base_param")
public class BaseParam implements Serializable {

    @Column(name = "TITLE", length = 50, unique = true, nullable = false)
    @JsonProperty("TITLE")
    private String title;
    
    @Id
    @Column(name = "TAG", length = 50, unique = true, nullable = false)
    @JsonProperty("TAG")
    private String tag;
    
    @Column(name = "SEQ_NO")
    @JsonProperty("SEQ_NO")
    private Integer seqNo;

    @Column(name = "CONTENT", length = 100)
    @JsonProperty("CONTENT")
    private String content;

    @Column(name = "CONTENT_ZH_TW", length = 100)
    @JsonProperty("CONTENT_ZH_TW")
    private String contentZhTw;

    @Column(name = "CONTENT_ZH_CN", length = 100)
    @JsonProperty("CONTENT_ZH_CN")
    private String contentZhCn;

    @Column(name = "CONTENT_EN_US", length = 100)
    @JsonProperty("CONTENT_EN_US")
    private String contentEnUs;

    @Column(name = "LANGUAGE", length = 100)
    @JsonProperty("LANGUAGE")
    private String language;

    
    @Column(name = "NOTES", length = 100)
    @JsonProperty("NOTES")
    private String notes;

    @Column(name = "STATUS", length = 1)
    @JsonProperty("STATUS")
    private String status;

    @Column(name = "CREATOR", length = 10)
    @JsonProperty("CREATOR")
    private String creator;

    @CreationTimestamp
    @Column(name = "CREATE_TIME")
    @JsonProperty("CREATE_TIME")
    private LocalDateTime createTime;

    @Column(name = "UPDATER", length = 10)
    @JsonProperty("UPDATER")
    private String updater;

    @UpdateTimestamp
    @Column(name = "UPDATE_TIME")
    @JsonProperty("UPDATE_TIME")
    private LocalDateTime updateTime;

}
