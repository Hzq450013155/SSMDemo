package testpac;

import com.ssm.core.entity.TodoItem;
import com.ssm.core.service.TodoItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name q
 * @description
 * @date 2018-10-08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class BeanAspectTest {

    @Autowired
    private TodoItemService todoItemService;


    @Test
    public void aspect() {

        List<TodoItem> list = todoItemService.getList(new TodoItem());
        System.out.println(list);
    }
}