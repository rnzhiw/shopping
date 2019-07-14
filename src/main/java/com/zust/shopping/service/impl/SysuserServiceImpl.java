package com.zust.shopping.service.impl;

import com.zust.shopping.common.LoginException;
import com.zust.shopping.model.dao.SysuserDAO;
import com.zust.shopping.model.domain.Sysuser;
import com.zust.shopping.model.dto.LoginDTO;
import com.zust.shopping.service.SysuserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统用户管理员服务实现类
 *
 * @author ruanzhiwei
 * @date 2019/7/9
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SysuserServiceImpl implements SysuserService {

    @Autowired
    private SysuserDAO sysuserDAO;

    @Override
    public LoginDTO getSysuserByLoginNameAndPassword(String loginName, String password) throws LoginException {

        LoginDTO loginDTO = new LoginDTO();

        Sysuser sysuser = sysuserDAO.findByLoginNameAndPassword(loginName,password);
        if(sysuser != null) {
            BeanUtils.copyProperties(sysuser,loginDTO);
            return loginDTO;
        } else {
            throw new LoginException("账号或密码不正确");
        }

    }
}
