package com.gwf.mybatis.mapper;


import com.gwf.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapperPlus {

    Employee getEmpById(Integer id);

    List<Employee> getAllEmps();

    Employee getEmpWithDeptById(Integer id);

    Employee getEmpWithDeptByIdStepByStep(Integer id);

    List<Employee> getEmpsByDeptId(Integer deptId);

}
