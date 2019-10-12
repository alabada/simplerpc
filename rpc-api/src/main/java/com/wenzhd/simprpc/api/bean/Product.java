package com.wenzhd.simprpc.api.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author wenzhd
 * @Date 2019/10/12
 * @Description 商品bean
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 4288135088580472493L;

    private Long id;

    private String name;

    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
