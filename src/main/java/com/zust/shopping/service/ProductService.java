package com.zust.shopping.service;

import com.zust.shopping.common.PageInfo;
import com.zust.shopping.model.dto.ProductDTO;
import org.springframework.stereotype.Service;

/**
 * 商品服务接口
 *
 * @author ruanzhiwei
 * @date 2019/7/16
 */
@Service
public interface ProductService {

    /**
     * 根据id查找商品
     *
     * @param id 商品id
     * @return
     */
    ProductDTO findOne(int id);

    /**
     * 返回当前的所有商品并分页
     *
     * @param pageSize 每页显示的条数
     * @param pageNum 页码
     * @return
     */
    PageInfo<ProductDTO> findAllProducts(Integer pageSize,Integer pageNum);

}
