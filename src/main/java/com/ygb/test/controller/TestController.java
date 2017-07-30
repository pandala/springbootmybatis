package com.ygb.test.controller;

import com.ygb.test.model.Category;
import com.ygb.test.model.User;
import com.ygb.test.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangguobiao on 2017/7/29.
 */
@RestController
@EnableAutoConfiguration
public class TestController {

  @Autowired
  private TestService testService;

  @RequestMapping("/hello")
  public String getWord() {
    return "hello 123";
  }

  @RequestMapping("/user/{id}")
  public User getUser(@PathVariable("id") String id) {
    System.out.println("user id: " + id);

    return testService.selectUserByPrimaryKey(Integer.valueOf(id));
  }

  @RequestMapping("/user/{id}/{name}")
  public Integer insertUser(@PathVariable("id") String id, @PathVariable("name") String name) throws Throwable {
    System.out.println("user id: " + id + " user name: " + name);

    return testService.insertUser(id, name);
  }

  @RequestMapping("/cat/{id}")
  public Category getCategory(@PathVariable("id") String id) {
    System.out.println("category id: " + id);

    return testService.selectCategoryByPrimaryKey(Integer.valueOf(id));
  }

  @RequestMapping("/cat/{id}/{name}/{desc}")
  public Integer insertCategory(@PathVariable("id") String id,
                              @PathVariable("name") String name,
                              @PathVariable("desc") String desc) {
    System.out.println("category id: " + id + " category name: " + name + "category desc: " + desc);

    return testService.insertCategory(id, name, desc);
  }

  @RequestMapping("/both/{userId}/{userName}/{catId}/{catName}/{catDesc}")
  public String insertUserAndCategory(@PathVariable("userId") String userId,
                                       @PathVariable("userName") String userName,
                                       @PathVariable("catId") String catId,
                                       @PathVariable("catName") String catName,
                                       @PathVariable("catDesc") String catDesc) throws Throwable {
    User user = new User();
    user.setId(Integer.valueOf(userId));
    user.setName(userName);

    Category category = new Category();
    category.setId(Integer.valueOf(catId));
    category.setCatname(catName);
    category.setCatdescription(catDesc);

    return testService.insertUserAndCategory(user, category);
  }

}
