package org.binshow.mapper;


import org.binshow.dao.Employee;

/**
 * Mapper 接口定义 操作数据库的方法
 *              具体的实现在 xml 中编写具体的sql语句
 */
public interface EmployeeMapper {

    Employee selectEmployee(Integer empId);

}
