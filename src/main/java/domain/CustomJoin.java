package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// import javax.persistence.SqlResultSetMapping;
// import javax.persistence.ConstructorResult;
// import javax.persistence.ColumnResult;

// @SqlResultSetMapping(
//     name = "UserMapping",
//     classes = @ConstructorResult(
//         targetClass = CustomJoin.class,
//         columns = {
//             @ColumnResult(name = "id", type = Long.class),
//             @ColumnResult(name = "name", type = String.class),
//             @ColumnResult(name = "email", type = String.class)
//         }
//     )
// )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomJoin implements Serializable{
    // select p.ITEM_NO, p.ITEM_NAME, p.PRICE, p.EFF_DATE_FROM, p.EFF_DATE_TO, 
	//    p.TAX, b.CONTENT_ZH_TW TAX_NAME, b.`LANGUAGE` TAX_LANGUAGE, 
	//    p.CREATOR, p.CREATE_TIME, p.UPDATER, p.UPDATE_TIME from product p 
    //    JOIN base_param b ON p.TAX = b.TAG;
    
    @JsonProperty("ITEM_NO")
    private String itemNo;

    @JsonProperty("ITEM_NAME")
    private String itemName;

    @JsonProperty("PRICE")
    private int price;

    @JsonProperty("EFF_DATE_FROM")
    private LocalDate effDateFrom;
    
    @JsonProperty("EFF_DATE_TO")
    private LocalDate effDateTo;

    @JsonProperty("TAX")
    private String tax;

    @JsonProperty("TAX_NAME")
    private String taxName;

    @JsonProperty("TAX_LANGUAGE")
    private String taxLanguage;

    @JsonProperty("CREATOR")
    private String creator;

    @CreationTimestamp
    @JsonProperty("CREATE_TIME")
    private LocalDateTime createTime;

    @JsonProperty("UPDATER")
    private String updater;

    @UpdateTimestamp
    @JsonProperty("UPDATE_TIME")
    private LocalDateTime updateTime;
    
}
