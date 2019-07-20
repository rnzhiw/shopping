package com.zust.shopping.controller.api;

import com.zust.shopping.common.AjaxResult;
import com.zust.shopping.common.PageInfo;
import com.zust.shopping.model.dto.ProductDTO;
import com.zust.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品api控制器
 *
 * @author ruanzhiwei
 * @date 2019/7/17
 */
@Controller
@RequestMapping("/userplat/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    /**
     * 返回所有的商品
     *
     * @param pageSize 每页有多少条纪录
     * @param pageNum 页数
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public AjaxResult list(Integer pageSize,Integer pageNum) {

        PageInfo<ProductDTO> pageInfo = productService.findAllProducts(pageSize, pageNum);

        return AjaxResult.success(pageInfo);
    }


    /**
     * 根据商品id删除商品
     *
     * @param id 商品id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Integer id) {
        System.out.println(id);
        try {
            boolean b = productService.deleteProductById(id);

            return AjaxResult.success("删除成功");


        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("删除失败");
        }
    }








}
