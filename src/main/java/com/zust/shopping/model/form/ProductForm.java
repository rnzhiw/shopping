package com.zust.shopping.model.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 商品增加和编辑表单
 *
 * @author ruanzhiwei
 * @date 2019/7/17
 */
public class ProductForm {

    /**
     * 商品id
     */
    private int id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private double price;

    /**
     * 图片文件
     */
    private CommonsMultipartFile file;

    private int productTypeId;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Override
    public String toString() {
        return "ProductForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", file=" + file +
                ", productTypeId=" + productTypeId +
                '}';
    }
}
