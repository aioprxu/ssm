package com.aiopr.service;

import com.aiopr.pojo.Category;
import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface CategoryService {
    List<Category> list();
    void add(Category category);
}
