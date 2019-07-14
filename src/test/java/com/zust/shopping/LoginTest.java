package com.zust.shopping;

import com.zust.shopping.common.LoginException;
import com.zust.shopping.model.dao.SysuserDAO;
import com.zust.shopping.model.domain.Sysuser;
import com.zust.shopping.model.dto.LoginDTO;
import com.zust.shopping.service.SysuserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 登录单元测试
 *
 * @author ruanzhiwei
 * @date 2019/7/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    @Autowired
    private SysuserDAO sysuserDAO;

    @Autowired
    private SysuserService sysuserService;


    @Test
    public void testLogin() {
//        System.out.println("ok");
//        LoginDTO loginDTO = new LoginDTO();
//        sysuserService.getSysuserByLoginNameAndPassword(loginDTO.setLoginName("aaa"),loginDTO.setPassword("123"));
        //测试DAO层
//        Sysuser sysuser = sysuserDAO.findByLoginNameAndPassword("111", "222");
//        if(sysuser == null) {
//            System.out.println("false");
//        } else {
//            System.out.println("true");
//        }

        //测试service层
        try {
            LoginDTO loginDTO = sysuserService.getSysuserByLoginNameAndPassword("111", "111");
            if(loginDTO == null) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }





    }
}
