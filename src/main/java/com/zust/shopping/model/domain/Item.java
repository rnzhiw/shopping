package com.zust.shopping.model.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 订单项实体类
 *
 * @author ruanzhiwei
 * @date 2019/7/8
 */
@Entity
@Table(name = "item")
public class Item {

    /**
     * 订单项唯一编号
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true,nullable = false,length = 11)
    private int id;

    /**
     * 订单项中的数量
     */
    @Column(name = "num",length = 11)
    private int num;

    /**
     * 订单项中的价格
     */
    @Column(name = "price")
    private double price;

    /**
     * 订单项与订单的关系：多对一
     */
    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    /**
     * 订单项与商品之间的关系：多对一
     */
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
