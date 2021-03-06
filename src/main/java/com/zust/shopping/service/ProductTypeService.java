package com.zust.shopping.service;

import com.zust.shopping.common.PageInfo;
import com.zust.shopping.common.ProductTypeException;
import com.zust.shopping.model.domain.ProductType;
import com.zust.shopping.model.dto.ProductTypeDTO;
import org.springframework.stereotype.Service;

/**
 * 商品类型服务接口
 *
 * @author ruanzhiwei
 * @date 2019/7/12
 */
@Service
public interface ProductTypeService {

    /**
     * 根据id查找商品类型
     *
     * @param id 商品类型id
     * @return
     */
    ProductTypeDTO findOne(int id);

    /**
     * 返回当前所有的商品类型并分页
     *
     * @param pageSize 每页显示的条数
     * @param pageNum 页码
     * @return
     */
    PageInfo<ProductTypeDTO> findAllProductTypes(Integer pageSize,Integer pageNum);

    /**
     * 根据id删除商品类型
     *
     * @param id 商品类型id
     * @return
     */
    boolean deleteProductTypeById(int id);

    /**
     * 保存商品类型
     *
     * @param name 商品类型
     * @return
     */
    ProductTypeDTO save(String name) throws ProductTypeException;

    /**
     * 更新商品类型
     *
     * @param id 商品类型id
     * @param name 商品类型名称
     * @return
     * @throws ProductTypeException
     */
    ProductTypeDTO update(int id,String name);

    /**
     * 修改商品类型状态
     * 1：启用
     * 2：禁用
     *
     * @param id 商品类型编号
     * @return
     */
    ProductTypeDTO updateStatus(int id);

}
