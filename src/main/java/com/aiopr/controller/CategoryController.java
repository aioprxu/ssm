package com.aiopr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiopr.service.*;
import com.aiopr.pojo.Category;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/29.
 */
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;



    @RequestMapping("listCategory")
    public ModelAndView listCategory(){
        ModelAndView mav = new ModelAndView();
        List<Category> cs= categoryService.list();
        categoryService.delete(6);
        categoryService.delete(7);
        categoryService.delete(8);
        categoryService.delete(9);

        // 放入转发参数
        mav.addObject("cs", cs);
        // 放入jsp路径
        mav.setViewName("listCategory");
        return mav;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView getCategory(Category category){
        categoryService.add(category);
        System.out.println(category.toString());
        return new ModelAndView("redirect:/listCategory");
    }

    @RequestMapping(value = "/test")
    public void test(){

    }
}
