package com.zust.shopping.model.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 订单实体类
 *
 * @author ruanzhiwei
 * @date 2019/7/7
 */
@Entity
@Table(name = "order")
public class Order {

    /**
     * 订单唯一编号
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true,nullable = false,length = 11)
    private int id;

    /**
     * 订单号
     */
    @Column(name = "no",nullable = false,length = 6)
    private int no;

    /**
     * 订单创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 订单价格
     */
    @Column(name = "price")
    private double price;

    /**
     * 订单与客户的关系：多对一
     */
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;



    /**
     * 订单与订单项的关系：一对多
     */
    @OneToMany(mappedBy = "order",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Item> item;

    /**
     * 订单与商品的关系：多对多
     */
    @ManyToMany(mappedBy = "order")
    private List<Product> product;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public List<Product> getProduct() {
        return product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
