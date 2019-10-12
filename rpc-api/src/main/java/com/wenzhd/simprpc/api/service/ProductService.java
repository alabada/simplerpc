package com.wenzhd.simprpc.api.service;

import com.wenzhd.simprpc.api.bean.Product;

/**
 * @Author wenzhd
 * @Date 2019/10/12
 * @Description 商品服务
 */
public interface ProductService {

    /**
     * 根据id查找商品
     * @param id
     * @return
     */
    Product getProductById(Long id);

}
