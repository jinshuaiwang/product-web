package com.example.product.service;


import com.example.product.model.Product;

import java.util.List;

/**
 * User: wangjinshuai
 * Time: 2022-05-02 10:15 AM
 * Email: jinshuaiwang@126.com
 */
public interface ProductService {

    /**
     * 商品列表
     * @return
     */
    List<Product> getProductList();

    /**
     * 添加商品
     * @param product
     * @return
     */
    Long addProduct(Product product);
}
