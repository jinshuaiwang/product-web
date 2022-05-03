package com.example.product.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * User: wangjinshuai
 * Time: 2022-05-01 4:09 PM
 * Email: jinshuaiwang@126.com
 */
@Configuration
@MapperScan("com.example.product.mapper")
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());
        return factoryBean.getObject();
    }

    public DataSource getDataSource() {
        PooledDataSource dataSource = new PooledDataSource();

        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=TRUE");

        return dataSource;
    }
}
