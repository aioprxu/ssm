package com.aiopr.service;

import com.aiopr.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiopr.pojo.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
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
}
