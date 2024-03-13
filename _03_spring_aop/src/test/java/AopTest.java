import org.binshow.agent.Calculator;
import org.binshow.config.MyConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;

@SpringJUnitConfig(value = MyConfig.class)
public class AopTest {


    @Resource
    private Calculator calculator;


    @Test
    public void testCalculator(){
        calculator.add(1,1);
    }


}
