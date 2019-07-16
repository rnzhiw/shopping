package com.zust.shopping;

import com.zust.shopping.model.dao.ProductTypeDAO;
import com.zust.shopping.service.ProductTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 商品类型单元测试
 *
 * @author ruanzhiwei
 * @date 2019/7/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTypeTest {


    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductTypeDAO productTypeDAO;

    @Test
    public void testDelete() {
        boolean b = productTypeService.deleteProductTypeById(1);
        boolean c = productTypeService.deleteProductTypeById(11);
        System.out.println(b);
        System.out.println(c);

    }

}
