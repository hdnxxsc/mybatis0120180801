package com.gwf.mybatis.mapper;

import com.gwf.mybatis.bean.Department;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DepartmentMapperTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void getDeptById() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            DepartmentMapper departmentMapper = openSession.getMapper(DepartmentMapper.class);
            Department department = departmentMapper.getDeptById(1);

            System.out.println(department);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void getDeptByIdWithEmps() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            DepartmentMapper departmentMapper = openSession.getMapper(DepartmentMapper.class);
            Department department = departmentMapper.getDeptByIdWithEmps(1);

            System.out.println(department);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void getDeptByIdWithEmpsStepByStep() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            DepartmentMapper departmentMapper = openSession.getMapper(DepartmentMapper.class);
            Department department = departmentMapper.getDeptByIdWithEmpsStepByStep(1);

            System.out.println(department.getDepartmentName());

            System.out.println("+++++++++++++++++++++++++++++++++++++++");

            System.out.println(department.getEmps());
        } finally {
            openSession.close();
        }
    }
}