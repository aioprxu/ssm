package com.aiopr.spring.controller;

import java.util.*;

import com.aiopr.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.aiopr.spring.service.*;
import com.aiopr.spring.pojo.Category;
import redis.clients.jedis.Jedis;


/**
 * Created by Administrator on 2017/10/29.
 */
@RestController
@RequestMapping("")
public class CategoryController extends Thread{

//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application.xml");

    @Autowired
    private CategoryService categoryService ;//= (CategoryService)applicationContext.getBean("CategoryService");
    //运用在方法上，会在每一个@RequestMapping标注的方法前执行，如果有返回值，则自动将该返回值加入到ModelMap中；
    @ModelAttribute
    public void testCategory(@RequestParam(value = "id")Integer id,Map<String,Object> map){
        Category category = categoryService.get(id);
        System.out.println("test modelattribute category"+category);
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
    public Map test(){
        Jedis jedis = new RedisUtil().getJedis();
        Set<byte[]> keySet = jedis.keys("*".getBytes());
        byte[][] keys = keySet.toArray(new byte[keySet.size()][]);
        // 获取所有value
        byte[][] values = jedis.mget(keys).toArray(new byte[keySet.size()][]);
        HashMap map = new HashMap();
        for(int i = 0; i < keySet.size(); ++i){
            map.put(byte2hex(keys[i]),byte2hex(values[i]));
        }
        return map;
    }

    private static String byte2hex(byte[] buffer) {
        String h = "0x";

        for (byte aBuffer : buffer) {
            String temp = Integer.toHexString(aBuffer & 0xFF);
            if (temp.length() == 1) {
                temp = "0" + temp;
            }
            h = h + " " + temp;
        }

        return h;

    }


    /*@RequestMapping(value = "/upload")
    public ModelAndView upload(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        upload.doPost(request,response);
        return new ModelAndView("redirect:/message");
    }

    @RequestMapping(value = "/message")
    public void message(){}*/

}
