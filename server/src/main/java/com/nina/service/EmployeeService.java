package com.nina.service;

import com.nina.dto.EmployeeDTO;
import com.nina.dto.EmployeeLoginDTO;
import com.nina.dto.EmployeePageQueryDTO;
import com.nina.entity.Employee;
import com.nina.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     * @param employeeDTO
     * @return
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);


    /**
     * 启用或禁用员工
     * @param status
     * @param id
     * @return
     */
    void startOrStop(Integer status, Long id);



    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    Employee getById(Long id);

    /**
     * 根据id查询员工信息
     * @param employeeDTO
     * @return
     */
    void update(EmployeeDTO employeeDTO);
}
