package com.aiopr.spring.mapper;

import com.aiopr.spring.pojo.Category;

/**
 * Created by Administrator on 2017/10/29.
 */
import java.util.List;
import java.util.Map;


public interface CategoryMapper {

    public void add(String name);

    public void delete(int id);

    public Category get(int id);

    public void update(Category category);

    public List<Category> list();

    public int count();

    Map<String,String> getAll()throws Exception;


}
