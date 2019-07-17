package com.zust.shopping.service.impl;

import com.zust.shopping.common.PageInfo;
import com.zust.shopping.model.dao.ProductDAO;
import com.zust.shopping.model.domain.Product;
import com.zust.shopping.model.domain.ProductType;
import com.zust.shopping.model.dto.ProductDTO;
import com.zust.shopping.model.dto.ProductTypeDTO;
import com.zust.shopping.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private ProductDAO productDAO;

    @Override
    public ProductDTO findOne(int id) {

        if(id == 0) {
            return null;
        }

        return e2d(productDAO.findById(id));
    }

    /**
     * 查找所有的商品并分页
     *
     * @param pageSize 每页显示的条数
     * @param pageNum 页码
     * @return
     */
    @Override
    public PageInfo<ProductDTO> findAllProducts(Integer pageSize, Integer pageNum) {

        if (pageSize == null || pageSize < 1 || pageNum == null || pageNum < 1) {
            return null;
        }

        Pageable pageable = new PageRequest(pageNum - 1, pageSize);
        Page<Product> p = productDAO.findAll(pageable);


        return page2PageInfo(p);
    }

    /**
     * 根据id删除商品
     *
     * @param id 商品id
     * @return
     */
//    @Override
//    public boolean deleteProductById(int id) {
//
//        if(id == 0) {
//            return false;
//        }
//
//        Product type = productDAO.findById(id);
//        if(type == null) {
//            return false;
//        }
//
//        productDAO.deleteById(id);
//        return true;
//    }



    /**
     * 返回productDTO分页结果
     *
     * @param p
     * @return
     */
    private PageInfo<ProductDTO> page2PageInfo(Page<Product> p) {

        if(p == null) {
            return null;
        }
        PageInfo<ProductDTO> pageInfo = new PageInfo<>();
        Integer page = p.getTotalPages();
        Integer pageNum = p.getNumber();
        pageInfo.setTotal(p.getTotalElements());
        if (pageNum == 0) {
            pageInfo.setFirstPage(true);
        } else {
            pageInfo.setFirstPage(false);
        }
        if (pageNum.equals(page)) {
            pageInfo.setLastPage(true);
        } else {
            pageInfo.setLastPage(false);
        }
        pageInfo.setPageNum(p.getNumber());
        pageInfo.setTotal(p.getTotalElements());
        pageInfo.setPages(page);
        pageInfo.setList(e2d(p.getContent()));
        pageInfo.setPageSize(p.getSize());
        pageInfo.setSize(p.getContent().size());

        return pageInfo;
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


        if(product.getProductType() != null) {
            productDTO.setProductTypeId(product.getProductType().getId());
            productDTO.setProductTypeName(product.getProductType().getName());
        }

        return productDTO;
    }

    /**
     * 将多个product转化为多个productDTO
     *
     * @param products
     * @return
     */
    private List<ProductDTO> e2d(List<Product> products) {

        if(products == null || products.size() == 0) {
            return new ArrayList<>();
        }

        List<ProductDTO> productDTOS = new ArrayList<>();

        for(Product product : products) {
            if(product != null) {
                productDTOS.add(e2d(product));
            }
        }

        return productDTOS;
    }


}
