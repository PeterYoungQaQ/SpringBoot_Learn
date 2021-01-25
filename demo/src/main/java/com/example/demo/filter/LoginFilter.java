package com.example.demo.filter;
/*
 * @Author: Haoran
 * @Date: 2021/1/25 0:56
 * @Description:
 */

import com.example.demo.domain.User;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.utils.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

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

        if (!StringUtils.isEmpty(token)){
            // TODO 判断token是否合法
            User user = UserServiceImpl.sessionMap.get(token);
            if (user != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                JsonData jsonData = JsonData.buildError("登入失败，token无效",-2);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(response,jsonStr);
            }
        }else {
            JsonData jsonData = JsonData.buildError("未登入",-3);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(response,jsonStr);
        }

    }

    /**
     * 容器销毁的时候使用
     */
    @Override
    public void destroy() {
        System.out.println("destroyed..");
    }

    /**
     * 获取Json数据
     * @param response
     * @param json
     */
    private void renderJson(HttpServletResponse response, String json){

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try(PrintWriter writer = response.getWriter()) {
            writer.print(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
