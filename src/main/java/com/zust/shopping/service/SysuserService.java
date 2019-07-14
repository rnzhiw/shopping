package com.zust.shopping.service;

import com.zust.shopping.common.LoginException;
import com.zust.shopping.model.dto.LoginDTO;
import org.springframework.stereotype.Service;

/**
 * 系统用户管理员服务接口
 *
 * @author ruanzhiwei
 * @date 2019/7/9
 */
@Service
public interface SysuserService {

    /**
     * 通过账号密码登录
     * @param loginName 账号
     * @param password 密码
     * @return
     */
    LoginDTO getSysuserByLoginNameAndPassword(String loginName,String password) throws LoginException;


}
