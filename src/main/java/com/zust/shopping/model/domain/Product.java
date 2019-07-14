package com.zust.shopping.model.domain;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 商品实体类
 *
 * @author ruanzhiwei
 * @date 2019/7/7
 */
@Entity
@Table(name = "product")
public class Product {

    /**
     * 商品唯一编号
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true,nullable = false,length = 11)
    private int id;

    /**
     * 商品名称
     */
    @Column(name = "name",length = 200,nullable = false)
    private String name;

    /**
     * 商品价格
     */
    @Column(name = "price")
    private double price;

    /**
     * 商品信息
     */
    @Column(name = "info",length = 200)
    private String info;

    /**
     * 商品图片存储地址
     */
    @Column(name = "image",length = 200)
    private String image;


    /**
     * 商品与客户的关系：多对多
     */
    @ManyToMany(mappedBy = "products")
    private List<Customer> customer;

    /**
     * 商品与订单的关系：多对多
     */
    @ManyToMany(targetEntity = Order.class)
    @JoinTable(name = "order_product", joinColumns = {@JoinColumn(name = "product_id")}, inverseJoinColumns =
            {@JoinColumn(name = "order_id")})
    private List<Order> order;



    /**
     * 商品与订单项的关系：一对多
     */
    @OneToMany(mappedBy = "product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Item> item;

    /**
     * 商品与商品类型的关系：多对一
     */
    @ManyToOne
    @JoinColumn(name = "productType_id",nullable = false)
    private ProductType productType;

    public void setSysuser(List<Sysuser> sysuser) {
        this.sysuser = sysuser;
    }

    /**
     * 商品与系统用户的关系：多对多
     */
    @ManyToMany(targetEntity = Sysuser.class)
    @JoinTable(name = "product_sysuser", joinColumns = {@JoinColumn(name = "product_id")}, inverseJoinColumns =
            {@JoinColumn(name = "sysuser_id")})
    private List<Sysuser> sysuser;

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public List<Sysuser> getSysuser() {
        return sysuser;
    }


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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public List<Customer> getCustomer() {
        return customer;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<Item> getItem() {
        return item;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

}
