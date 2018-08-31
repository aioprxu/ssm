package com.aiopr.spring.service;

import com.aiopr.spring.pojo.Category;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface CategoryService {
    List<Category> list();
    void add(Category category);
    void delete(Integer id);
    void update(Category category);
    Category get(Integer id);
    Map<String,String> getAll() throws Exception;
}
