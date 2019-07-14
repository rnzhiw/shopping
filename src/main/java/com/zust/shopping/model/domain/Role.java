package com.zust.shopping.model.domain;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 角色实体类
 *
 * @author ruanzhiwei
 * @date 2019/7/8
 */
@Entity
@Table(name = "role")
public class Role {

    /**
     * 角色唯一编号
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true,nullable = false,length = 11)
    private int id;

    /**
     * 角色名字
     * 1：商品专员
     * 2：营销经理
     * 3：超级管理员
     * 4:普通用户
     */
    @Column(name = "role_name",nullable = false,length = 50)
    private String roleName;

    /**
     * 角色与系统用户管理员的关系：一对多
     */
    @OneToMany(mappedBy = "role",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Sysuser> sysusers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
