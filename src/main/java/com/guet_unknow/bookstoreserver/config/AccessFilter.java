package com.guet_unknow.bookstoreserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 提供跨域支持
 *
 * @author cyan
 * @since 2022-12-17 11:06:35
 */
@Slf4j
@Configuration
public class AccessFilter implements Filter, WebMvcConfigurer {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.OK.value());
            return;
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }

    @Value("${filepath.dir}")
    String filePath;
    @Value("${filepath.setResourceHandler}")
    String setResourceHandler;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //其中addResourceHandler表示访问的前缀。addResourceLocations 是文件真实的存储路径
        registry.addResourceHandler(setResourceHandler).addResourceLocations("file:"+filePath);
    }

}
