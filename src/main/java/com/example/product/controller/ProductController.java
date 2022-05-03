package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: wangjinshuai
 * Time: 2022-05-01 3:40 PM
 * Email: jinshuaiwang@126.com
 */
@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> getProductList() {
        return productService.getProductList();
    }

    @PostMapping("/add")
    public Long addProduct(Product product) {
        return productService.addProduct(product);
    }

}
