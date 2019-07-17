package com.zust.shopping.service.impl;

import com.zust.shopping.common.PageInfo;
import com.zust.shopping.model.domain.Product;
import com.zust.shopping.model.domain.ProductType;
import com.zust.shopping.model.dto.ProductDTO;
import com.zust.shopping.model.dto.ProductTypeDTO;
import com.zust.shopping.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品服务实现类
 *
 * @author ruanzhiwei
 * @date 2019/7/16
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductDTO findOne(int id) {
        return null;
    }

    @Override
    public PageInfo<ProductDTO> findAllProducts(Integer pageSize, Integer pageNum) {

        return null;
    }

    /**
     * 将product转化成productDTO
     *
     * @param product 商品
     * @return
     */
    private ProductDTO e2d(Product product) {

        if(product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);



        return null;
    }

    /**
     * 将多个product转化为多个productDTO
     *
     * @param products
     * @return
     */
    private List<ProductDTO> e2d(List<Product> products) {

        return null;
    }


}
