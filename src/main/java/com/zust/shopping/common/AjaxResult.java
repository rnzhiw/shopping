package com.zust.shopping.common;

/**
 * Ajax返回包装类
 *
 * @author ruanzhiwei
 * @date 2019/7/12
 */
public class AjaxResult {

    /**
     * 所有json返回的数据都用这个类进行封装，success表示是否成功执行，msg表示消息描述，data封装数据
     * 有些公司的json返回还有错误码，这个随公司规定的，没有统一的
     * 但是基本上下面这些属性大家都有，前端只要判断错误码或者success属性就能获取是否请求成功
     * 因为data里可以放各种类型数据，所以是object类型
     *
     * 一般请求成功的话，success为true，msg为空，data放数据，但是你msg一定要写也可以
     * 一般请求失败的话，success为false，msg写错误原因，data为空
     * 基本上就这样
     *
     *
     */

    private Boolean success = true;

    private String message;

    private Object data;

    /**
     * 将构造方法设为私有，拒绝外部直接调用构造方法，推荐外部调用静态方法获取
     */
    private AjaxResult() {
    }

    public static AjaxResult success() {
        return AjaxResult.success(null);
    }

    public static AjaxResult success(String msg) {
        return AjaxResult.success(null, msg);
    }

    public static AjaxResult success(Object data) {
        return AjaxResult.success(data, null);
    }

    public static AjaxResult success(Object data, String msg) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(true);
        ajaxResult.setData(data);
        ajaxResult.setMessage(msg);
        return ajaxResult;
    }

    public static AjaxResult error() {
        return AjaxResult.error(null);
    }

    public static AjaxResult error(String msg) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        ajaxResult.setMessage(msg);
        return ajaxResult;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
