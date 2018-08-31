package com.aiopr;

import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class MyInterceptor implements HandlerInterceptor {

    private List<String> list = Arrays.asList("/login","/v2/api-docs");

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI().replace(httpServletRequest.getContextPath(),"");
        if(list.contains(url)||url.contains("swagger"))
            return true;
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        Result res = new Result();
//        httpServletResponse.setContentType("text/json;charset=utf-8");
        res.setStatus(ReturnStatusEnum.LOGIN_ERROR.getValue());
        res.setMessage(ReturnStatusEnum.LOGIN_ERROR.getDesc());
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName("utf-8")))) {
            writer.write(JSON.toJSONString(res));
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
