package net.java.test.springbootsearchrestapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import domain.CustomJoin;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.java.test.springbootsearchrestapi.entity.BaseParam;
import net.java.test.springbootsearchrestapi.entity.Products;
import net.java.test.springbootsearchrestapi.repository.BaseParamRepository;
import net.java.test.springbootsearchrestapi.repository.ProductsRepository;
import net.java.test.springbootsearchrestapi.service.ProductsService;

@Slf4j
@RestController
@RequestMapping("api/v1/products")
@CrossOrigin(origins = "*")
public class ProductsController {
    
    @Resource
    private ProductsService productsService;

    @Resource
    private ProductsRepository productsRepository;

    @Resource
    private BaseParamRepository baseParamRepository;

    public ProductsController(){
        
    }
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }
    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    public ProductsController(BaseParamRepository baseParamRepository) {
        this.baseParamRepository = baseParamRepository;
    }

    @SneakyThrows
    @RequestMapping("/test")
    public String testReadProducts(){
        log.info("Get====ProductsController.testReadProducts");

        String resultStr = "[";

        List<Products> productsList = productsService.readProducts();

        for(Products element :productsList){
            ObjectMapper mapper = new ObjectMapper();
            
            mapper.registerModule(new JavaTimeModule());
            String str = mapper.writeValueAsString(element);
            resultStr += str + ",";
        }
        return resultStr + "]";
    }

    // @RequestMapping("/id")
    // public ResponseEntity<List<Products>> readProductsByID(String id){
    //     System.out.println("Get===============Products");
    //     return ResponseEntity.ok(productsService.readProductsById(id));
    // }

    @RequestMapping
    public ResponseEntity<List<Products>> readAllProducts(){
        System.out.println("Get===============Products");
        return ResponseEntity.ok(productsService.readProducts());
    }

    @PostMapping("/joinQuery")
    public ResponseEntity<List<Map<String, String>>> joinQueryAll(@RequestBody Products products){
        return ResponseEntity.ok(productsService.customFind(products));
    }

    @RequestMapping("/id")
    public Optional<Products> readProductsByID(String id){
        System.out.println("Get===============Products");
        return productsRepository.findById(id);
    }

    @SneakyThrows
    @RequestMapping("/ITEM_NO")
    public List<Products> readProductsByITEM_NO(@RequestBody String products){
        log.info("Post====ProductsController.readProductsByITEM_NO");

        ObjectMapper objectMapper = new ObjectMapper();
        Products requestProducts = objectMapper.readValue(products, Products.class);

        return productsRepository.findByItemNo(requestProducts.getItemNo());
    }

    @SneakyThrows
    @PostMapping("/postRead")
    public List<Products> postReadProducts(@RequestBody String products){
        log.info("Post====ProductsController.postReadProducts");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Products requestProducts = objectMapper.readValue(products, Products.class);

        return productsRepository.postFindAll(
                    requestProducts.getItemNo(), 
                    requestProducts.getItemName(), 
                    requestProducts.getTax(),
                    requestProducts.getEffDateFrom(),
                    requestProducts.getEffDateTo());
    }

    public ResponseEntity<List<Map<String,String>>> postReadProducts2(@RequestBody Products products){
        return ResponseEntity.ok(productsService.postReadProducts2(products));
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createProducts(@RequestBody Products products){
        return ResponseEntity.ok(productsService.createProducts(products));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateProducts(@PathVariable String id, @RequestBody Products products){
        return ResponseEntity.ok(productsService.updateProductsById(id, products));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProducts(@PathVariable String id) {
        return ResponseEntity.ok(productsService.deleteProductsById(id));
    }

    @SneakyThrows
    @PostMapping("/querySelectOptions")
    public List<Map<String, Object>> querySelectOptions(@RequestBody String baseParam) {

        ObjectMapper objectMapper = new ObjectMapper();
        BaseParam requestBaseParam = objectMapper.readValue(baseParam, BaseParam.class);

        List<BaseParam> baseParamList = baseParamRepository.findByTitle(requestBaseParam.getTitle());
        System.out.println(baseParamList.get(0).getCreateTime());
        
        List mapList = new ArrayList<>();
        for(BaseParam element :baseParamList){

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            Map<String, Object> newMap = mapper.convertValue(element, Map.class);

            newMap.keySet().removeAll(new HashSet<String>(Arrays.asList(
                "TITLE", "TAG", 
                "CONTENT_ZH_TW", "CONTENT_ZH_CN", "CONTENT_EN_US",
                "NOTES", "STATUS", 
                "CREATOR", "CREATE_TIME", "UPDATER", "UPDATE_TIME"
                )));

            // newMap.remove("TITLE");
            // newMap.remove("TAG");
            // ...

            newMap.put("VALUE", element.getSeqNo());
            newMap.remove("SEQ_NO");

            newMap.put("LABEL", element.getContent());
            newMap.remove("CONTENT");

            mapList.add(newMap);
        }
        System.out.println(mapList);

    //    return baseParamList;
       return mapList;
    }


}
