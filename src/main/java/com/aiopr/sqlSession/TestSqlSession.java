package com.aiopr.sqlSession;

import com.aiopr.spring.mapper.CategoryMapper;
import com.aiopr.spring.pojo.Category;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

public class TestSqlSession {
    public static void main(String[] args) throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        DataSource dataSource = (DataSource) ac.getBean("dataSource");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.aiopr.spring.pojo");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:CategoryMapper.xml"));
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        CategoryMapper categoryMapper1 = sqlSession1.getMapper(CategoryMapper.class);
        Category category = categoryMapper.get(1);
        System.out.println("111111111111111111111111");
        Category category1 = categoryMapper.get(1);
        System.out.println("2222222222222222222222222222");
        sqlSession.commit();
        Category category2 = categoryMapper1.get(1);
        sqlSession1.commit();
        System.out.println("33333333333333333333333333");
        System.out.println(category+category1.toString());
    }
}
