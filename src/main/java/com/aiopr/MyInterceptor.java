package com.aiopr;

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

    private List<String> list = Arrays.asList("/login","/test");

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI().replace(httpServletRequest.getContextPath(),"");
        if(list.contains(url))
            return true;
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName("utf-8")))) {
            writer.write("{hhh:hhh}");
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
