package com.zust.shopping.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 客户实体类
 *
 * @author ruanzhiwei
 * @date 2019/7/7
 */
@Entity
@Table(name = "customer")
public class Customer {

    /**
     * 客户唯一编号
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true,nullable = false,length = 6)
    private int id;

    /**
     * 客户昵称
     */
    @Column(name = "name",length = 20)
    private String name;

    /**
     * 客户登录名
     */
    @Column(name = "login_name",nullable = false,unique = true,length = 20)
    private String loginName;

    /**
     * 客户密码
     */
    @Column(name = "password",length = 20)
    @JsonIgnore
    private String password;

    /**
     * 客户电话
     */
    @Column(name = "phone",nullable = false,unique = true,length = 20)
    private String phone;

    /**
     * 客户地址
     */
    @Column(name = "address",length = 30)
    private String address;

    /**
     * 客户的状态
     *  1：启用
     *  2：禁用
     */
    @Column(name = "is_valid",length = 6)
    private int isValid;

    /**
     * 客户的注册日期
     */
    @Column(name = "register_date")
    private Date registerDate;

    /**
     * 用户与订单的关系:一对多
     */
    @OneToMany(mappedBy = "customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Order> orders;

    /**
     * 用户与商品的关系：多对多
     */
    @ManyToMany(targetEntity = Product.class)
    @JoinTable(name = "customer_product", joinColumns = {@JoinColumn(name = "customer_id")}, inverseJoinColumns =
            {@JoinColumn(name = "product_id")})
    private List<Product> products;

    /**
     * 用户与管理用户的管理员的关系：多对多
     */
    @ManyToMany(targetEntity = Sysuser.class)
    @JoinTable(name = "customer_sysuser", joinColumns = {@JoinColumn(name = "customer_id")}, inverseJoinColumns =
            {@JoinColumn(name = "sysuser_id")})
    private List<Sysuser> sysusers;


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Sysuser> getSysusers() {
        return sysusers;
    }

    public void setSysusers(List<Sysuser> sysusers) {
        this.sysusers = sysusers;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
