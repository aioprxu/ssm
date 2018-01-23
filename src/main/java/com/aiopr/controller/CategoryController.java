package com.aiopr.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aiopr.service.*;
import com.aiopr.pojo.Category;
import java.io.*;


/**
 * Created by Administrator on 2017/10/29.
 */
@Controller
@RequestMapping("")
public class CategoryController extends Thread{

//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

    @Autowired
    private CategoryService categoryService ;//= (CategoryService)applicationContext.getBean("CategoryService");
    @ModelAttribute
    public void testCategory(@RequestParam(value = "id")Integer id,Map<String,Object> map){
        Category category = categoryService.get(id);
        System.out.println("tset modelattribute category"+category);
        map.put("category",category);
    }

    @RequestMapping("listCategory")
    public ModelAndView listCategory(){
        ModelAndView mav = new ModelAndView();
        List<Category> cs= categoryService.list();


        // 放入转发参数
        mav.addObject("cs", cs);
        // 放入jsp路径
        mav.setViewName("listCategory");
        return mav;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView getCategory(Category category){
        System.out.println("修改"+category.toString());
        //categoryService.update(category);
        System.out.println(category.toString());
        return new ModelAndView("forward:/listCategory");
    }

    @RequestMapping(value = "/test")
    public void test(){}


    /*@RequestMapping(value = "/upload")
    public ModelAndView upload(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        upload.doPost(request,response);
        return new ModelAndView("redirect:/message");
    }

    @RequestMapping(value = "/message")
    public void message(){}*/

}
