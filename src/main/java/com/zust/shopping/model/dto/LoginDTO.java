package com.zust.shopping.model.dto;

/**
 * 系统用户管理员登录DTO
 *
 * @author ruanzhiwei
 * @date 2019/7/9
 */
public class LoginDTO {

    /**
     * 系统管理用户登录名
     */
    private String loginName;

    /**
     * 系统管理用户密码
     */
    private String password;

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
}
