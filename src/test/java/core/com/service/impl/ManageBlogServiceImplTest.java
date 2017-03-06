package core.com.service.impl;

import core.com.base.TestBase;
import core.com.model.manage.AddBlogReq;
import core.com.model.manage.AddBlogResp;
import core.com.service.manage.impl.ManageBlogServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Test
 * <p>
 * Created by wangjianan on 17-3-3.
 */
public class ManageBlogServiceImplTest extends TestBase {

    @Autowired
    private ManageBlogServiceImpl manageBlogService;

    @Before
    public void setUp() throws Exception {
        System.out.println("开始执行: setUp()");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("开始执行: tearDown()");
    }

    @Test
    public void doBlogLoanTest() {
        System.out.println("开始执行测试: begin");
        AddBlogReq req = new AddBlogReq();
        List<String> marks = new ArrayList<>();
        marks.add("87378f28-2257-413b-81d7-ae9475c81bd6");
        marks.add("6aeead61-ebe5-463f-a0bc-3aba5e790511");
//        marks.add("8502dfe8-40c4-4432-8b1d-ade1ad8f134f");
        marks.add("a22b80e9-acf1-4f54-8ef8-d3f579aa5a56");

        req.setId(40);
        req.setChannel("2f06398e-3eeb-4d21-aebd-2fc5ac72823a");
        req.setType("1");
        req.setName("王佳楠 Markdown");
        req.setMarks(marks);

        AddBlogResp resp = manageBlogService.doBlogLoan(req);
        Assert.notNull(resp);

        System.out.println("开始执行测试: end");
    }

}
