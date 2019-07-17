package com.zust.shopping.service.impl;

import com.zust.shopping.common.PageInfo;
import com.zust.shopping.common.ProductTypeException;
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

    /**
     * 根据id查询商品类型
     *
     * @param id 商品类型id
     * @return
     */
    @Override
    public ProductTypeDTO findOne(int id) {

        if(id == 0) {
            return null;
        }

        return e2d(productTypeDAO.findById(id));
    }

    /**
     * 查找所有的商品类型并分页
     *
     * @param pageSize 每页显示的条数
     * @param pageNum 页码
     * @return
     */
    @Override
    public PageInfo<ProductTypeDTO> findAllProductTypes(Integer pageSize, Integer pageNum) {

        if(pageSize == null || pageSize < 1 || pageNum == null || pageNum < 1) {
            return null;
        }

        Pageable pageable = new PageRequest(pageNum - 1, pageSize);
        Page<ProductType> p = productTypeDAO.findAll(pageable);

        return page2pageInfo(p);
    }

    /**
     * 根据id删除商品类型
     *
     * @param id 商品类型id
     * @return
     */
    @Override
    public boolean deleteProductTypeById(int id) {

        if(id == 0) {
            return false;
        }

        ProductType type = productTypeDAO.findById(id);
        if(type == null) {
            return false;
        }

        productTypeDAO.deleteById(id);
        return true;
    }

    /**
     * 保存商品类型
     *
     * @param name 商品类型
     * @return
     */
    @Override
    public ProductTypeDTO save(String name) throws ProductTypeException {

        ProductType productType = productTypeDAO.findByName(name);

        if(productType != null) {
            throw new ProductTypeException("该商品类型已存在");
        }

        ProductType productType1 = new ProductType();

        productType1.setName(name);
        //默认为启用,status为1
        productType1.setStatus(1);
        return e2d(productTypeDAO.save(productType1));
    }

    /**
     * 更改商品类型
     * @param id 商品类型id
     * @param name 商品类型名称
     * @return
     * @throws ProductTypeException
     */
    @Override
    public ProductTypeDTO update(int id,String name) {

        ProductType productType = productTypeDAO.getOne(id);

        if(productType == null) {
            return null;
        }

        productType.setName(name);

        return e2d(productTypeDAO.save(productType));

    }

    /**
     * 修改商品类型状态
     * 1：启用
     * 2：禁用
     *
     * @param id 商品类型编号
     * @return
     */
    @Override
    public ProductTypeDTO updateStatus(int id) {

        ProductType productType = productTypeDAO.getOne(id);

        if(productType == null) {
            return null;
        }

        int status = productType.getStatus();
        if(status == 1) {
            status = 2;
        } else {
            status = 1;
        }
        productType.setStatus(status);

        return e2d(productTypeDAO.save(productType));
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
