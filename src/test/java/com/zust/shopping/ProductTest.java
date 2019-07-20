package com.zust.shopping;

import com.zust.shopping.model.dao.ProductDAO;
import com.zust.shopping.model.dao.ProductTypeDAO;
import com.zust.shopping.model.domain.Product;
import com.zust.shopping.model.domain.ProductType;
import com.zust.shopping.model.dto.ProductDTO;
import com.zust.shopping.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 商品单元测试
 *
 * @author ruanzhiwei
 * @date 2019/7/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductService productService;


    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductTypeDAO productTypeDAO;

    @Test
    public void testList() {
        ProductDTO productDTO = productService.findOne(1);
        Integer status = productDTO.getStatus();
        String name = productDTO.getName();
        System.out.println(status);
        System.out.println(name);
    }

    @Test
    public void testProductStatus() {
        Product product = productDAO.findById(1);
    }

    @Test
    public void testDelete() {
        //测试service层
//        ProductDTO productDTO = productService.findOne(7);
//        String name = productDTO.getName();
//        System.out.println(name);
        //测试DAO层
//        Product product = productDAO.findById(7);
//        String name = product.getName();
//        System.out.println(name);


    }

}
