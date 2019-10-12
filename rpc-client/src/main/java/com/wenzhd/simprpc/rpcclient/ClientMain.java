package com.wenzhd.simprpc.rpcclient;

import com.alibaba.fastjson.JSON;
import com.wenzhd.simprpc.api.bean.Product;
import com.wenzhd.simprpc.api.service.ProductService;
import com.wenzhd.simprpc.rpcclient.rpc.RpcUtils;

/**
 * @Author wenzhd
 * @Date 2019/10/12
 * @Description 调用商品查询服务
 */
public class ClientMain {

    public static void main(String[] args) {
        // 发起远程调用
        ProductService productService = (ProductService) RpcUtils.rpcInvoke(ProductService.class);
        Product product = productService.getProductById(1L);

        System.out.println(JSON.toJSONString(product));
    }

}
