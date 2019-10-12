package com.wenzhd.simprpc.rpcserver.service.impl;

import com.wenzhd.simprpc.api.bean.Product;
import com.wenzhd.simprpc.api.service.ProductService;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author wenzhd
 * @Date 2019/10/12
 * @Description 商品服务实现类
 */
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long id) {

        Product product = new Product();
        product.setId(123L);
        product.setName("wenzhd");
        product.setPrice(new BigDecimal(66.662).setScale(2, BigDecimal.ROUND_HALF_UP));

        return product;
    }
}
