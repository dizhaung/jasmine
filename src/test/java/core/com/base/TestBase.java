package core.com.base;

import core.com.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * base config
 *
 * Created by wangjianan on 17-3-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestBase {

    @Before
    public void setUp() throws Exception {
        System.out.println("开始执行: TestBase setUp()");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("开始执行: TestBase tearDown()");
    }

    @Test
    public void printInfo() {
    }
}
