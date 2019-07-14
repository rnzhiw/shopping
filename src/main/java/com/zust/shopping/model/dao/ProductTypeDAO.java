package com.zust.shopping.model.dao;

import com.zust.shopping.model.domain.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据库product_type表访问接口
 *
 * @author ruanzhiwei
 * @date 2019/7/12
 */
@Repository
public interface ProductTypeDAO extends JpaRepository<ProductType,Integer> {

    /**
     * 通过id查询商品类型
     * @param id
     * @return
     */
    ProductType findById(int id);

    /**
     * 获取所有的商品类型
     * @param pageable
     * @return
     */
    Page<ProductType> findAll(Pageable pageable);

}
