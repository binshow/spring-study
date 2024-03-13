package org.binshow.mapper;


import org.apache.ibatis.annotations.Param;
import org.binshow.dao.Employee;

import java.util.List;
import java.util.Map;

/**
 * Mapper 接口定义 操作数据库的方法
 *              具体的实现在 xml 中编写具体的sql语句
 */
public interface EmployeeMapper {

    Employee selectEmployee(Integer empId); // 返回实体类

    int insertEmployee(Employee employee);


    int updateEmployee(@Param("empId") Integer empId, @Param("empSalary") Double empSalary);


    // 根据map传参
    int updateEmployeeByMap(Map<String, Object> paramMap);



    int selectEmpCount(); // 返回一个 int


    Map<String,Object> selectEmpNameAndMaxSalary(); // 返回一个map



    List<Employee> selectAll(); // 返回list

    int insertEmployeeReturn(Employee employee);  // 返回自增型主键



    Employee selectEmployeeByRM(Integer empId);

}
