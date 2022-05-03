package com.example.product.service.impl;

import com.example.product.mapper.ProductMapper;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: wangjinshuai
 * Time: 2022-05-01 3:41 PM
 * Email: jinshuaiwang@126.com
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductList() {
        return productMapper.getProductList();
    }

    @Override
    public Long addProduct(Product product) {
//        try {
//            Thread.sleep(RandomUtils.nextInt(0, 100));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return productMapper.addProduct(product);
    }
}
