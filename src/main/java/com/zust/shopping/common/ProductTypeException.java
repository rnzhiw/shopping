package com.zust.shopping.common;

/**
 * 商品类型异常类
 *
 * @author ruanzhiwei
 * @date 2019/7/16
 */
public class ProductTypeException extends Exception {
    public ProductTypeException() {
        super();
    }

    public ProductTypeException(String message) {
        super(message);
    }

    public ProductTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductTypeException(Throwable cause) {
        super(cause);
    }

    protected ProductTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
