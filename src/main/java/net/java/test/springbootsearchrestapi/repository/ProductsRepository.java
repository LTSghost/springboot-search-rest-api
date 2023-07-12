package net.java.test.springbootsearchrestapi.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import domain.CustomJoin;
import jakarta.transaction.Transactional;
import net.java.test.springbootsearchrestapi.entity.Products;

// import javax.persistence.SqlResultSetMapping;
// import javax.persistence.ConstructorResult;
// import javax.persistence.ColumnResult;

public interface ProductsRepository extends JpaRepository<Products, String> {

    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Products> readProducts();

    // @Query(value = "SELECT ITEM_NO FROM Product p where p.ITEM_NO like %:ITEM_NO%")
    // List<Products> readProductsById(@Param("ITEM_NO") String ITEM_NO);

    @Query(value = "SELECT * FROM product where ITEM_NO = :ITEM_NO", nativeQuery = true)
    List<Products> readProductsById(@Param("ITEM_NO") String ITEM_NO);

    // @Query(value = "select * from book b where b.name=?1", nativeQuery = true)
    // List<Book> findByName(String name);

    // @Query(value = "select name,author,price from Book b where b.name like %:name%")
    // List<Book> findByNameMatch(@Param("name") String name);

    List<Products> findByItemNo(String itemNo);

    @Query(value = "SELECT * FROM product WHERE " +
                   "LOWER(ITEM_NO) = LOWER(:itemNo)" + " AND " +
                   "LOWER(ITEM_NAME) LIKE LOWER(CONCAT('%',:itemName,'%'))" + " AND " +
                   "LOWER(TAX) LIKE LOWER(CONCAT('%',:tax,'%'))" + " AND " +
                   "LOWER(EFF_DATE_FROM) LIKE LOWER(CONCAT('%',:effDateFrom,'%'))" + " AND " +
                   "LOWER(EFF_DATE_TO) LIKE LOWER(CONCAT('%',:effDateTo,'%'))", nativeQuery = true)
    List<Products> postFindAll(String itemNo, String itemName, String tax, LocalDate effDateFrom, LocalDate effDateTo);

    @Query(value = "select p.ITEM_NO, p.ITEM_NAME, p.PRICE, p.EFF_DATE_FROM, p.EFF_DATE_TO, " +
    "p.TAX, b.CONTENT_ZH_TW TAX_NAME, b.`LANGUAGE` TAX_LANGUAGE, " +
    "p.CREATOR, p.CREATE_TIME, p.UPDATER, p.UPDATE_TIME from product p " +
    "JOIN base_param b ON p.TAX = b.TAG;", nativeQuery = true)
    List<Map<String, String>> customFindAll();

    @Query(value = "select p.ITEM_NO, p.ITEM_NAME, p.PRICE, p.EFF_DATE_FROM, p.EFF_DATE_TO, " +
    "p.TAX, b.CONTENT_ZH_TW TAX_NAME, b.`LANGUAGE` TAX_LANGUAGE, " +
    "p.CREATOR, p.CREATE_TIME, p.UPDATER, p.UPDATE_TIME from product p " +
    "JOIN base_param b ON p.TAX = b.TAG " +
    "WHERE LOWER(ITEM_NAME) LIKE LOWER(CONCAT('%',:itemName,'%'))", nativeQuery = true)
    List<Map<String, String>> customFindCondition(String itemName);

    // @Modifying
    // @Query(value = "DELETE FROM product WHERE ITEM_NO= :itemNo", nativeQuery = true)
    // List<Products> deleteProductsById(@Param("itemNo") String itemNo);
    
}
