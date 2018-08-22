package com.gwf.mybatis.mapper;

import com.gwf.mybatis.bean.Department;

public interface DepartmentMapper {

    Department getDeptById(Integer id);

    Department getDeptByIdWithEmps(Integer id);

    Department getDeptByIdWithEmpsStepByStep(Integer id);

}
