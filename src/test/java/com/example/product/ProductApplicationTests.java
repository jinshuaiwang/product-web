package com.example.product;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@SpringBootTest
class ProductApplicationTests {

	@Autowired
	private ThreadPoolExecutor productThreadPoolExecutor;

	@Autowired
	private ProductService productService;

	@Test
	void contextLoads() {
	}

	private int productSize = 10000;


	@Test
	void testAddProductConcurrent() {

		long start = System.currentTimeMillis();

		List<CompletableFuture<Long>> completableFutureList = Lists.newArrayListWithCapacity(productSize);

		for (int i = 0; i < productSize; i++) {
			Product product = new Product();

			product.setName("p" + i);
			product.setPrice(BigDecimal.valueOf(i));

			CompletableFuture future = CompletableFuture.supplyAsync(() -> {
				return productService.addProduct(product);
			}, productThreadPoolExecutor);

			completableFutureList.add(future);
		}

		for(int i = 0; i < productSize; i++) {
			try {
				Long result = completableFutureList.get(i).get(1000, TimeUnit.MILLISECONDS);
				log.info("testAddProduct i:{}, result:{}", i, result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		}

		log.info("testAddProductConcurrent cost:{}", System.currentTimeMillis() - start);
	}

	@Test
	void testAddProductSerial() {
		long start = System.currentTimeMillis();

		for (int i = 0; i < productSize; i++) {
			Product product = new Product();

			product.setName("p" + i);
			product.setPrice(BigDecimal.valueOf(i));

			productService.addProduct(product);
		}

		log.info("testAddProductSerial cost:{}", System.currentTimeMillis() - start);
	}

}
