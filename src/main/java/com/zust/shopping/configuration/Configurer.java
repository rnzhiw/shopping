package com.zust.shopping.configuration;


import com.zust.shopping.interceptor.AuthInterceptor;
import com.zust.shopping.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置器
 *
 * @author fuenhui
 * @date 2018/8/28
 */
@Configuration
public class Configurer extends WebMvcConfigurerAdapter {

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册登录拦截器
        InterceptorRegistration loginReg = registry.addInterceptor(new LoginInterceptor());
        //添加需要拦截的url
        loginReg.addPathPatterns("/**");
        //拦截器放行的url
        loginReg.excludePathPatterns("/login");

        //注册权限拦截器
        InterceptorRegistration authReg = registry.addInterceptor(new AuthInterceptor());
        //添加需要拦截的url
        authReg.addPathPatterns("/**");
        //拦截器放行的url
        authReg.excludePathPatterns("/login");

        super.addInterceptors(registry);
    }

}
