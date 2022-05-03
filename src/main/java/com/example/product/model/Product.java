package com.example.product.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * User: wangjinshuai
 * Time: 2022-05-01 3:47 PM
 * Email: jinshuaiwang@126.com
 */
@Data
public class Product {

    private Long id;

    private String name;

    private BigDecimal price;
}
