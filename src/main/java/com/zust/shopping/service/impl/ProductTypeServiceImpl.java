package com.zust.shopping.service.impl;

import com.zust.shopping.common.PageInfo;
import com.zust.shopping.model.dao.ProductTypeDAO;
import com.zust.shopping.model.domain.Product;
import com.zust.shopping.model.domain.ProductType;
import com.zust.shopping.model.dto.ProductTypeDTO;
import com.zust.shopping.service.ProductTypeService;
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
 * 商品类型服务实现类
 *
 * @author ruanzhiwei
 * @date 2019/7/12
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDAO productTypeDAO;

    @Override
    public ProductTypeDTO findOne(int id) {
        return null;
    }

    @Override
    public PageInfo<ProductTypeDTO> findAllProductTypes(Integer pageSize, Integer pageNum) {

        if(pageSize == null || pageSize < 1 || pageNum == null || pageNum < 1) {
            return null;
        }

        Pageable pageable = new PageRequest(pageNum - 1, pageSize);
        Page<ProductType> p = productTypeDAO.findAll(pageable);

        return page2pageInfo(p);
    }

    @Override
    public boolean deleteProductTypeById(int id) {
        return false;
    }

    /**
     * 返回ProductTypeDTO分页结果
     *
     * @param p
     * @return
     */
    private PageInfo<ProductTypeDTO> page2pageInfo(Page<ProductType> p) {

        if(p == null) {
            return null;
        }
        PageInfo<ProductTypeDTO> pageInfo = new PageInfo<>();
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
     * 将productType转化成productTypeDTO
     *
     * @param productType 商品类型
     * @return
     */
    private ProductTypeDTO e2d(ProductType productType) {

        if(productType == null) {
            return null;
        }

        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        BeanUtils.copyProperties(productType,productTypeDTO);

        //将Product对象转化为productId和productName存入到ProductTypeDTO中
        List<Integer> productIds = new ArrayList<>();
        List<String> productNames = new ArrayList<>();
        if(productType.getProduct() != null && productType.getProduct().size() != 0) {
            for(Product product : productType.getProduct()) {
                productIds.add(product.getId());
                productNames.add(product.getName());
            }
        }

        productTypeDTO.setProductIds(productIds);
        productTypeDTO.setProductNames(productNames);

        return productTypeDTO;
    }

    /**
     * 将多个productType转化为多个productTypeDTO
     *
     * @param productTypes
     * @return
     */
    private List<ProductTypeDTO> e2d(List<ProductType> productTypes) {

        if(productTypes == null || productTypes.size() == 0) {
            return new ArrayList<>();
        }

        List<ProductTypeDTO> productTypeDTOS = new ArrayList<>();

        for(ProductType productType : productTypes) {
            if(productType != null) {

                productTypeDTOS.add(e2d(productType));
            }
        }

        return productTypeDTOS;
    }

}
