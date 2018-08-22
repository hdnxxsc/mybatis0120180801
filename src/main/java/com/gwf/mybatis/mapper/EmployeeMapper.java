package com.gwf.mybatis.mapper;


import com.gwf.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    List<Employee> getAllEmps();

}
