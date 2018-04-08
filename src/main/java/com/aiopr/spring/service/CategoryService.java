package com.aiopr.spring.service;

import com.aiopr.spring.pojo.Category;
import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface CategoryService {
    List<Category> list();
    void add(Category category);
    void delete(Integer id);
    void update(Category category);
    Category get(Integer id);
}