import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.binshow.dao.Customer;
import org.binshow.dao.Order;
import org.binshow.mapper.CustomerMapper;
import org.binshow.mapper.OrderMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest {

    private SqlSession session;


    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mappers/mybatis-config.xml")).openSession();
    }


    @Test
    public void testToOne() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        // 查询Order对象，检查是否同时查询了关联的Customer对象
        Order order = orderMapper.queryOrderById(2);

        System.out.println(order);
        System.out.println(order.getCustomer());
    }

    @Test
    public void testRelationshipToMulti() {

        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        // 查询Customer对象同时将关联的Order集合查询出来
        List<Customer> customers = customerMapper.queryList();
        customers.forEach(System.out::println);

    }


    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }

}
