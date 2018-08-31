package com.aiopr.spring.service;

import com.aiopr.spring.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiopr.spring.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/29.
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired(required = false)
    private CategoryMapper categoryMapper;



    public List<Category> list(){
        return categoryMapper.list();
    };

    public void add(Category category){
        categoryMapper.add(category.getName());
    }

    public void delete(Integer id){
        categoryMapper.delete(id);
    }

    public void update(Category category){categoryMapper.update(category);}

    public Category get(Integer id){return categoryMapper.get(id);}

    public Map<String,String> getAll()throws Exception{return categoryMapper.getAll();}
}
