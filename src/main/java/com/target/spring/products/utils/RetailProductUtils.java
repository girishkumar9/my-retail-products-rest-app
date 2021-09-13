package com.target.spring.products.utils;

import com.target.spring.products.model.Product;
import org.springframework.util.StringUtils;

public class RetailProductUtils {

    public static boolean isGetRequestValid(String id){
        if(StringUtils.isEmpty(id)) return false;
        return true;
    }

    public static boolean isPutRequestValid(String id, Product product){
        if(StringUtils.isEmpty(id)) return false;
        if(product == null) return false;
        if(product.getPrice() == null) return false;
        return true;
    }
}
