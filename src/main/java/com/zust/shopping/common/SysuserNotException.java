package com.zust.shopping.common;

/**
 * @author ruanzhiwei
 * @date 2019/7/9
 */
public class SysuserNotException extends Exception {
    public SysuserNotException() {
        super();
    }

    public SysuserNotException(String message) {
        super(message);
    }

    public SysuserNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public SysuserNotException(Throwable cause) {
        super(cause);
    }

    protected SysuserNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
