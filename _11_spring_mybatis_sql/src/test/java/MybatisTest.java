import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.binshow.dao.Employee;
import org.binshow.mapper.EmployeeMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试 Mybatis
 */

public class MybatisTest {


    @Test
    public void testSelectEmployee() throws IOException {
        // 1.创建SqlSessionFactory对象
        // ①声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mappers/mybatis-config.xml";

        // ②以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.使用SqlSessionFactory对象开启一个会话
        SqlSession session = sessionFactory.openSession();

        // 3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 4. 调用代理类方法既可以触发对应的SQL语句
        Employee employee = employeeMapper.selectEmployee(1);

        System.out.println("employee = " + employee.toString());

        // 4.关闭SqlSession
        session.commit(); //提交事务 [DQL不需要,其他需要]
        session.close(); //关闭会话

    }


    private SqlSession session;


    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mappers/mybatis-config.xml")).openSession();
    }


    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setEmpName("bin");
        employee.setEmpSalary(99999.99);
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        int res = employeeMapper.insertEmployee(employee);
        System.out.println("insert res: " + res);  // 返回影响的行数
    }



    @Test
    public void testUpdate(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        int res = employeeMapper.updateEmployee(999 , 11111.1);
        System.out.println("update res: " + res);

        Employee afterEmployee = employeeMapper.selectEmployee(999);
        System.out.println("after " + afterEmployee);
    }


    /**
     * 测试根据 map 传入零散参数
     */
    @Test
    public void testUpdateEmpNameByMap() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("empSalaryKey", 999.99);
        paramMap.put("empIdKey", 5);
        int result = mapper.updateEmployeeByMap(paramMap);
        System.out.println("res = " + result);
    }



    @Test
    public void testSelectEmpCount() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int count = mapper.selectEmpCount();
        System.out.println("count = " + count);
    }


    @Test
    public void testSelectAll() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.selectAll();
        list.forEach(System.out::println);
    }



    @Test
    public void testQueryEmpNameAndSalary() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> resultMap = employeeMapper.selectEmpNameAndMaxSalary();
        Set<Map.Entry<String, Object>> entrySet = resultMap.entrySet();

        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key = " + key + " , value = " + value);
        }
    }


    @Test
    public void testInsertEmployeeReturn() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpSalary(888.88);
        employee.setEmpName("haha");

        int res = employeeMapper.insertEmployeeReturn(employee);
        System.out.println("返回主键 id = " + employee.getEmpId());
    }




    @AfterEach
    public void clear(){
        session.commit();
        session.close();
    }

}
