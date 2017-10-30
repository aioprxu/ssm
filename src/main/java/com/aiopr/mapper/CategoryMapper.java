package com.aiopr.mapper;

import com.aiopr.pojo.Category;

/**
 * Created by Administrator on 2017/10/29.
 */
import java.util.List;


public interface CategoryMapper {

    public void add(String name);

    public void delete(int id);

    public Category get(int id);

    public void update(Category category);

    public List<Category> list();

    public int count();


}
