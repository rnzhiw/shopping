package com.zust.shopping.model.dto;

import java.util.List;

/**
 * 商品类型DTO
 *
 * @author ruanzhiwei
 * @date 2019/7/8
 */
public class ProductTypeDTO {

    /**
     * 商品类型唯一编号
     */
    private int id;

    /**
     * 商品类型名称
     */
    private String name;

    /**
     * 商品名称id集合
     */
    private List<Integer> productIds;

    /**
     * 商品名称集合
     */
    private List<String> productNames;

    /**
     * 商品类型状态
     * 1：启用
     * 2：禁用
     */
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productIds=" + productIds +
                ", productNames=" + productNames +
                ", status=" + status +
                '}';
    }
}
