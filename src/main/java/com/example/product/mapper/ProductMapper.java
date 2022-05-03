package com.example.product.mapper;

import com.example.product.model.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: wangjinshuai
 * Time: 2022-05-01 4:15 PM
 * Email: jinshuaiwang@126.com
 */
@Repository
public interface ProductMapper {

    @Select("select id, `name`, price from product")
    List<Product> getProductList();

    @Insert("insert into product (`name`, price) VALUES (#{name}, #{price})")
    Long addProduct(Product product);
}
