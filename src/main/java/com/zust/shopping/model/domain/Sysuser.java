package com.zust.shopping.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 系统管理用户实体类
 *
 * @author ruanzhiwei
 * @date 2019/7/7
 */
@Entity
@Table(name = "sysuser")
public class Sysuser {

    /**
     * 系统管理用户唯一编号
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true,nullable = false,length = 11)
    private int id;

    /**
     * 系统管理用户昵称
     */
    @Column(name = "name",length = 50)
    private String name;

    /**
     * 系统管理用户登录名
     */
    @Column(name = "login_name",nullable = false,unique = true,length = 50)
    private String loginName;

    /**
     * 系统管理用户密码
     */
    @Column(name = "password",length = 50)
    private String password;

    /**
     * 系统管理用户电话
     */
    @Column(name = "phone",unique = true,length = 20)
    private String phone;

    /**
     * 系统管理用户地址
     */
    @Column(name = "address",length = 30)
    private String address;

    /**
     * 系统管理用户的状态
     *  1：启用
     *  2：禁用
     */
    @Column(name = "is_valid",length = 6)
    private int isValid;

    /**
     * 系统管理用户的注册日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 系统管理用户与客户的关系：多对多
     */
    @ManyToMany(mappedBy = "sysusers")
    private List<Customer> customer;

    /**
     * 系统管理用户与商品的关系：多对多
     */
    @ManyToMany(mappedBy = "sysuser")
    private List<Product> product;

    /**
     * 系统管理用户与商品类型的关系：多对多
     */
    @ManyToMany(mappedBy = "sysusers")
    private List<ProductType> productType;



    /**
     * 系统管理用户与角色的关系：多对一
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void setProductType(List<ProductType> productType) {
        this.productType = productType;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public List<Product> getProduct() {
        return product;
    }

    public List<ProductType> getProductType() {
        return productType;
    }

    public Role getRole() {
        return role;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }



    public void setRole(Role role) {
        this.role = role;
    }
}
