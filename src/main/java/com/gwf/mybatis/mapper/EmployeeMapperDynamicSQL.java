package com.gwf.mybatis.mapper;

import com.gwf.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamicSQL {

    // 查询员工，要求携带什么条件就依什么条件查询
    List<Employee> getEmpsConditionIf(Employee employee);

    List<Employee> getEmpsConditionTrim(Employee employee);

    List<Employee> getEmpsConditionChoose(Employee employee);

    void updateEmployee(Employee employee);

    List<Employee> getEmpsConditionForEach(@Param("ids") List<Integer> ids);

    void addEmps(@Param("emps")List<Employee> emps);

}
