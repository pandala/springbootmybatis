package com.ygb.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by yangguobiao on 2017/7/29.
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.ygb.test.mapper")
public class ApplicationMain {

  @Bean
  @ConfigurationProperties(prefix="spring.datasource")
  public DataSource dataSource() {
    return new org.apache.tomcat.jdbc.pool.DataSource();
  }

  @Bean
  public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource());

    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    //sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));

    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  public static void main(String[] args) {
    SpringApplication.run(ApplicationMain.class, args);
  }
}
