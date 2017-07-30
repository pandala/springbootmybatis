package com.ygb.test.model;

import java.io.Serializable;

/**
 * Created by yangguobiao on 2017/7/30.
 */
public class Category implements Serializable {

  private static final long serialVersionUID = 2L;

  private Integer id;

  private String catname;

  private String catdescription;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCatname() {
    return catname;
  }

  public void setCatname(String catname) {
    this.catname = catname;
  }

  public String getCatdescription() {
    return catdescription;
  }

  public void setCatdescription(String catdescription) {
    this.catdescription = catdescription;
  }
}
