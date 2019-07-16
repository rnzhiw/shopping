package com.zust.shopping.controller.api;

import com.zust.shopping.common.AjaxResult;
import com.zust.shopping.common.PageInfo;
import com.zust.shopping.common.ProductTypeException;
import com.zust.shopping.model.dto.ProductTypeDTO;
import com.zust.shopping.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 返回所有的商品类型
     *
     * @param pageSize 每页有多少条纪录
     * @param pageNum 页数
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public AjaxResult list(Integer pageSize, Integer pageNum) {

        PageInfo<ProductTypeDTO> pageInfo = productTypeService.findAllProductTypes(pageSize, pageNum);

        return AjaxResult.success(pageInfo);
    }

    /**
     * 根据id删除商品类型
     *
     * @param id 商品类型id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Integer id) {
        System.out.println(id);
        try {
            boolean b = productTypeService.deleteProductTypeById(id);

            return AjaxResult.success("删除成功");


        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("删除失败");
        }

    }

    /**
     * 添加商品类型
     *
     * @param name 商品类型名称
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(String name) {

        System.out.println(name);
        try {
            ProductTypeDTO productTypeDTO = productTypeService.save(name);
            return AjaxResult.success("添加成功");
        } catch (ProductTypeException e) {
            e.printStackTrace();
            return AjaxResult.error("添加失败");
        }
    }

    /**
     * 修改商品类型
     *
     * @param id 商品类型id
     * @param name 商品类型名称
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(int id,String name) {

        System.out.println(name);
        try {
            ProductTypeDTO productTypeDTO = productTypeService.update(id,name);
            return AjaxResult.success("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.success("更新失败");
        }
    }

    /**
     * 修改商品类型状态
     * 1：启用
     * 2：禁用
     *
     * @param id
     * @return
     */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public AjaxResult updateStatus(int id) {
        System.out.println(id);

        try {
            ProductTypeDTO productTypeDTO = productTypeService.updateStatus(id);
            return AjaxResult.success("更新商品类型状态成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("更新商品类型状态失败");
        }


    }

}
