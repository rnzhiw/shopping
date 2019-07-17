package com.zust.shopping.model.dto;

import java.util.List;

/**
 * 商品DTO
 *
 * @author ruanzhiwei
 * @date 2019/7/16
 */
public class ProductDTO {

    /**
     * 商品唯一编号
     */
    private Integer id;

    /**
     * 商品类型名称
     */
    private String name;

    /**
     * 商品价格
     */
    private Double price;

    /**
     * 商品状态
     * 1：启用
     * 2：禁用
     */
    private Integer status;

    /**
     * 商品图片存储地址
     */
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", image='" + image + '\'' +
                '}';
    }
}
