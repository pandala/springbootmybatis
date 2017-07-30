package com.ygb.test.service;

import com.ygb.test.mapper.CategoryMapper;
import com.ygb.test.mapper.UserMapper;
import com.ygb.test.model.Category;
import com.ygb.test.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangguobiao on 2017/7/30.
 */
@Service
public class TestService {
  @Autowired
  private UserMapper userMapper;

  @Autowired
  private CategoryMapper categoryMapper;

  public User selectUserByPrimaryKey(Integer id) {
    return userMapper.selectByPrimaryKey(id);
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
  public Integer insertUser(String id, String name) throws Throwable {
    User user = new User();
    user.setId(Integer.valueOf(id));
    user.setName(name);
    Integer retNum = userMapper.insert(user);
//    if (retNum == 1) {
//      throw new Throwable("test transaction");
//    }

    return retNum;
  }

  public Category selectCategoryByPrimaryKey(Integer id) {
    return categoryMapper.selectByPrimaryKey(id);
  }

  public Integer insertCategory(String id, String name, String desc) {
    Category category = new Category();
    category.setId(Integer.valueOf(id));
    category.setCatname(name);
    category.setCatdescription(desc);
    Integer retNum = categoryMapper.insert(category);

    return retNum;
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
  public String insertUserAndCategory(User user, Category category) throws Throwable {
    Integer retNum = userMapper.insert(user);
    if (retNum == 1) {
      throw new Throwable("error");
    }
    categoryMapper.insert(category);

    return "ok";
  }




}
