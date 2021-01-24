package com.example.demo.filter;
/*
 * @Author: Haoran
 * @Date: 2021/1/25 0:56
 * @Description:
 */

import com.example.demo.domain.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    /**
     * 容器加载的时候使用
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Do filter======");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            token = request.getParameter("token");
        }

        if (StringUtils.isEmpty(token)){
            return;
        }else {
            // TODO 判断token是否合法
            User user = UserServiceImpl.sessionMap.get(token);
            if (user != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }

        }
    }

    /**
     * 容器销毁的时候使用
     */
    @Override
    public void destroy() {
        System.out.println("destroyed..");
    }
}
