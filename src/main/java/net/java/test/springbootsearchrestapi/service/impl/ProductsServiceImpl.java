package net.java.test.springbootsearchrestapi.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.java.test.springbootsearchrestapi.entity.Products;
import net.java.test.springbootsearchrestapi.repository.ProductsRepository;
import net.java.test.springbootsearchrestapi.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{

    private ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Products> readProducts() {
        List<Products> productsList = productsRepository.readProducts();
        return productsList;
    }

    @Override
    public List<Products> readProductsById(String id) {
        List<Products> productsList = productsRepository.readProductsById(id);
        return productsList;
    }

    @Override
    public Map<String, String> updateProductsById(String id, Products products) {
        Map<String, String> newMap = new HashMap<>();

        Products newProduct = productsRepository.findById(id).get();
        System.out.println("Find By Id newProduct" + newProduct.getPrice());

        System.out.println(products.getItemName() + ", " + products.getPrice() + ", " + products.getEffDateFrom() + ", " +
                           products.getEffDateTo() + ", " + products.getTax() + ", " + products.getUpdater());

        newProduct.setItemName(products.getItemName());
        newProduct.setPrice(products.getPrice());
        newProduct.setEffDateFrom(products.getEffDateFrom());
        newProduct.setEffDateTo(products.getEffDateTo());
        newProduct.setTax(products.getTax());
        newProduct.setUpdater(products.getUpdater());

        productsRepository.save(newProduct);

        newMap.put("Status", "Y");
        newMap.put("Message", "修改成功");

        return newMap;
    }

    @Override
    public Map<String, String> deleteProductsById(String id) {
        Map<String, String> newMap = new HashMap<>();

        for (Products element :this.readProducts()){
            if ( id.equals(element.getItemNo()) ) {
                productsRepository.deleteById(id);
                System.out.println("delete " + id);
                break;
            }
        }

        newMap.put("Status", "Y");
        newMap.put("Message", "刪除成功");

        return newMap;
    }

    @Override
    public Map<String, String> createProducts(Products products) {
        Map<String, String> newMap = new HashMap<>();

        productsRepository.save(products);

        newMap.put("Status", "Y");
        newMap.put("Message", "新增成功");

        return newMap;
    }

    @Override
    public List<Map<String, String>> postReadProducts2(Products products) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postReadProducts2'");
    }

    @Override
    public List<Map<String, String>> customFind(Products products) {

        if ("".equals(products.getItemNo()) && "".equals(products.getItemName()) &&
            "".equals(products.getTax()) && products.getEffDateFrom() == null && products.getEffDateTo() == null) {
            return productsRepository.customFindAll();
        }

        List<Map<String, String>> customFindCondition = productsRepository.customFindCondition(products.getItemName()); // All joinQueryData

        // // add
        List<Map<String, String>> resultList = new ArrayList<>();
        // for(Map<String, String> element: customFindCondition){
        //     if (products.getItemNo().equals(element.get("ITEM_NO"))) {
        //         // if (products.getEffDateFrom() != null) {
        //         //     if (products.equals(element.get("EFF_DATE_FROM"))) {
                        
        //         //     }
        //         // }
        //         resultList.add(element);
        //         return resultList;
        //     }
        // }


        // // remove
        for(Map<String, String> element: customFindCondition){
            // if (!products.getItemNo().equals(element.get("ITEM_NO"))) {
            //     if ("".equals(products.getItemNo())) {
            //         System.out.println("ITEM_NO is empty");
            //         if (!products.getTax().equals(element.get("TAX"))) {
            //             if ("".equals(products.getTax())) {
            //                 System.out.println("TAX is empty");
            //                 if (!products.getEffDateFrom().equals(element.get("EFF_DATE_FROM"))){
            //                     if ( "".equals(products.getEffDateFrom())) {
            //                         System.out.println("EFF_DATE_FROM is empty");
            //                         if (!products.getEffDateTo().equals(element.get("EFF_DATE_TO"))) {
            //                             if ("".equals(products.getEffDateTo())) {
            //                                 System.out.println("EFF_DATE_TO is empty");
            //                             }
            //                             resultList.add(element);
            //                         }
            //                     }
            //                     resultList.add(element);
            //                 }
            //             }
            //             resultList.add(element);
            //         }
            //     }
            //     System.out.println("not found ITEM_NO");
            //     resultList.add(element);
            // }
        
            // if (!products.getItemNo().equals(element.get("ITEM_NO"))) {
            //     if ("".equals(products.getItemNo())) {
            //         System.out.println("ITEM_NO pass");
            //         if (!products.getTax().equals(element.get("TAX"))) {
            //             if ("".equals(products.getTax())) {
            //                 System.out.println("TAX pass");
            //                 if (!products.getEffDateFrom().equals(element.get("EFF_DATE_FROM"))) {
            //                     if ("".equals(products.getEffDateFrom())) {
            //                         System.out.println("EFF_DATE_FROM pass");
            //                     } else {
            //                         resultList.add(element);
            //                     }
            //                 }
            //             } else {
            //                 resultList.add(element);
            //             }
            //         }
            //     } else {
            //         System.out.println("is not empty");
            //         System.out.println(element.get("ITEM_NO") + "is not currect");
            //         resultList.add(element);
            //     }
            // }

            // no equal
            if (!products.getItemNo().equals(element.get("ITEM_NO"))) {
                if ("".equals(products.getItemNo())) {
                    System.out.println("ITEM_NO pass");
                } else {
                    System.out.println("is not empty");
                    System.out.println(element.get("ITEM_NO") + "is not currect");
                    resultList.add(element);
                }
            } 
            // if (!products.getTax().equals(element.get("TAX"))) {
            //     resultList.add(element);
            // }
            // if (!products.getEffDateFrom().equals(element.get("EFF_DATE_FROM"))) {
            //     resultList.add(element);
            // }
            // if (!products.getEffDateTo().equals(element.get("EFF_DATE_TO"))) {
            //     resultList.add(element);
            // }
        }

        System.out.println("Using remove method");
        customFindCondition.removeAll(resultList);
        


        return customFindCondition;
    }

}
