package com.ygb.test.mapper;

import com.ygb.test.model.Category;

/**
 * Created by yangguobiao on 2017/7/30.
 */
public interface CategoryMapper {

  Integer insert(Category record);

  Category selectByPrimaryKey(Integer id);
}
