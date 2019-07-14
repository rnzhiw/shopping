package com.zust.shopping.model.domain;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 商品类型实体类
 *
 * @author ruanzhiwei
 * @date 2019/7/8
 */
@Entity
@Table(name = "product_type")
public class ProductType {

    /**
     * 商品类型唯一编号
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true,nullable = false,length = 11)
    private int id;

    /**
     * 商品类型名称
     */
    @Column(name = "name",nullable = false,length = 200)
    private String name;

    /**
     * 商品类型状态
     * 1：启用
     * 2：禁用
     */
    @Column(name = "status",length = 11)
    private int status;

    /**
     * 商品类型与商品的对应关系：一对多
     */
    @OneToMany(mappedBy = "productType",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Product> product;

    /**
     * 商品类型与系统管理用户的关系：多对多
     */
    @ManyToMany(targetEntity = Sysuser.class)
    @JoinTable(name = "sysuser_productType", joinColumns = {@JoinColumn(name = "productType_id")}, inverseJoinColumns =
            {@JoinColumn(name = "sysuser_id")})
    private List<Sysuser> sysusers;

    public int getId() {
        return id;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
