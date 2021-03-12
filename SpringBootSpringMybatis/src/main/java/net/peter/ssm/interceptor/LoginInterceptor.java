package net.peter.ssm.interceptor;
/*
 * @Author: Haoran
 * @Date: 2021/3/12 8:36
 * @Description: 登入校验类
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import net.peter.ssm.utils.JWTUtils;
import net.peter.ssm.utils.JsonData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入到controller之前的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            String accessToken = request.getHeader("token");
            if (accessToken == null){
                request.getParameter("token");
            }

            // 如果token不为空的情况下
            if (StringUtils.isNotBlank(accessToken)){
                Claims claims = JWTUtils.checkJWT(accessToken);
                if (claims == null){
                    // 如果为空，告诉登入失败，重新登入
                    sendJsonMessage(response, JsonData.buildError("登入过期，重新登入"));
                    return false;
                }
                Integer userId = (Integer) claims.get("id");
                String userName = (String) claims.get("name");
                String userPhone = (String) claims.get("phone");

                request.setAttribute("user_id", userId);
                request.setAttribute("user_name", userName);
                request.setAttribute("user_phone", userPhone);

                return true;
            }
        }catch (Exception ignored){}

        return false;
    }

    /**
     * 响应json数据，将错误信息通过流信息传递给前端
     * @param response
     * @param object
     */
    public static void sendJsonMessage(HttpServletResponse response, Object object){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println(objectMapper.writeValueAsString(object));
            writer.close();
            response.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
