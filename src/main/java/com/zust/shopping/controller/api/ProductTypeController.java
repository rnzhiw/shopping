package com.zust.shopping.controller.api;

import com.zust.shopping.common.AjaxResult;
import com.zust.shopping.common.PageInfo;
import com.zust.shopping.model.dto.ProductTypeDTO;
import com.zust.shopping.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品类型api控制器
 *
 * @author ruanzhiwei
 * @date 2019/7/12
 */
@Controller
@RequestMapping("/userplat/producttype")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 访问商品类型管理界面
     *
     * @return
     */
    @RequestMapping
    public String index() {
        return "/userplat/main";
    }

    public AjaxResult list(Integer pageSize, Integer pageNum) {

        PageInfo<ProductTypeDTO> pageInfo = productTypeService.findAllProductTypes(pageSize, pageNum);

        return AjaxResult.success(pageInfo);
    }


}
