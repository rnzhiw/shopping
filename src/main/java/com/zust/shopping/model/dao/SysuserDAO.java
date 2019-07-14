package com.zust.shopping.model.dao;

import com.zust.shopping.model.domain.Sysuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 数据库Sysuser表访问接口
 *
 * @author ruanzhiwei
 * @date 2019/7/9
 */
@Repository
public interface SysuserDAO extends JpaRepository<Sysuser,Integer> {

    /**
     * 系统用户管理员登录
     * @param loginName 登录名
     * @param password 密码
     * @return
     */
    Sysuser findByLoginNameAndPassword(String loginName,String password);


}
