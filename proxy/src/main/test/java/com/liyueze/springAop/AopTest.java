package com.liyueze.springAop;

import com.liyueze.springAop.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/ApplicationContext.xml"})
/**
 * classpath和classpath*区别:
 *
 * classpath：只会到你的class路径中查找找文件。
 *
 * classpath*：不仅包含class路径，还包括jar文件中（class路径）进行查找。
 */
public class AopTest {

    @Autowired
    UserDao userDao;

    @Test
    public void test(){
        userDao.save("1");
    }

    @Test
    public void test1()
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:/ApplicationContext.xml");
        UserDao dao = (UserDao) ac.getBean("userDao");
        dao.save("11");
    }
}
