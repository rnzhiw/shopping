package com.zust.shopping.model.dao;

import com.zust.shopping.model.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ruanzhiwei
 * @date 2019/7/16
 */
@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {

    /**
     * 通过id查询商品
     *
     * @param id 商品id
     * @return
     */
    Product findById(int id);

    /**
     * 获取所有的商品并分页
     *
     * @param pageable
     * @return
     */
    Page<Product> findAll(Pageable pageable);

}
