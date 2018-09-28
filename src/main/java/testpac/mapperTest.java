package testpac;

import com.ssm.core.entity.TodoItem;
import com.ssm.core.mapper.TodoItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name mapperTset
 * @description
 * @date 2018-08-01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class mapperTest {

    @Autowired
    TodoItemMapper todoItemMapper;

    @Test
    public void testMapper() {
//        创建IOC容器
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        从容器中获取mapper
//        final TodoItemMapperl bean = ioc.getBean(TodoItemMapperl.class);

        System.out.println(todoItemMapper);

        todoItemMapper.insert(new TodoItem(Long.valueOf(2), "吃吃吃", "喝喝喝", "HIGH", new Date(), new Date(), "hahha"));

    }
}
