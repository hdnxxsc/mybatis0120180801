package com.gwf.mybatis.mapper;

import com.gwf.mybatis.bean.Department;
import com.gwf.mybatis.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeMapperDynamicSQLTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void getEmpsConditionIf() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, "%g%", null, null, null);
            List<Employee> emps = mapper.getEmpsConditionIf(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        } finally {
            openSession.close();
        }
    }

    @Test
    public void getEmpsConditionTrim() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, "%g%", null, null, null);
            List<Employee> emps = mapper.getEmpsConditionTrim(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        } finally {
            openSession.close();
        }
    }

    @Test
    public void getEmpsConditionChoose() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, null, null, null, null);
            List<Employee> emps = mapper.getEmpsConditionChoose(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        } finally {
            openSession.close();
        }
    }

    @Test
    public void updateEmployee() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(1, "admin", null, null, null);
            mapper.updateEmployee(employee);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void getEmpsConditionForEach() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> emps = mapper.getEmpsConditionForEach(Arrays.asList(1, 2));
            for (Employee emp : emps) {
                System.out.println(emp);
            }

        } finally {
            openSession.close();
        }
    }

    @Test
    public void addEmps() throws IOException {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);

            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee(null,"smith","smith@163.com","1",new Department(1)));
            emps.add(new Employee(null,"tom","tom@163.com","0",new Department(2)));
            emps.add(new Employee(null,"jerry","jerry@163.com","1",new Department(1)));
            emps.add(new Employee(null,"jack","jack@163.com","1",new Department(2)));

            mapper.addEmps(emps);
            openSession.commit();
        } finally {
            openSession.close();
        }
    }
}