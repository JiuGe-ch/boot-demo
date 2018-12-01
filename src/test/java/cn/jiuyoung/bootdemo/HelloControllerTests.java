package cn.jiuyoung.bootdemo;

import static org.junit.Assert.*;
// import static org.mockito.ArgumentMatchers.startsWith;

import org.junit.*;
// import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cn.jiuyoung.bootdemo.Controller.HelloController;

@RunWith(SpringRunner.class) //使用Spring的test组件
@SpringBootTest              //表示一个Spring Boot 测试
@AutoConfigureMockMvc        //自动配置MockMvc
@WebAppConfiguration         //启动一个真实的web服务

/**
 * HelloControllerTests
 */
public class HelloControllerTests {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private HelloController helloController;

    // @Rule
    // public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setupMockMvc() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void indexTest() {
        String string = "Hello Spring boot";
        assertEquals(string, helloController.index());
    }

    @Test
    public void indexMappingTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/index"))
            .andExpect(MockMvcResultMatchers.view().name("index"));
    }
    // @Test(expected=Exception.class)
    // public void helloTest() throws Exception {
    //     mvc.perform(MockMvcRequestBuilders.post("/ss"));
    // }

    // @Test
    // public void helloTest1() throws Exception {
    //     thrown.expect(Exception.class);
    //     thrown.expectMessage(startsWith("出现"));
    //     mvc.perform(MockMvcRequestBuilders.post("/ss"));
    // }
}