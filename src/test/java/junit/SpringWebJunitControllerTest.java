package junit;

import org.consume.com.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SpringWebJunitControllerTest {

    // 引入要测试的controller
    // @Autowired
    // private UserController controller;

    // private MockMvc mockMvc;
    //
    // @Before
    // public void setup() {
    // mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    // }
    //
    // @Test
    // // 插入需要此注解，不然插不进数据库
    // @Rollback(false)
    // // 测试前先注释权限判断的代码
    // public void addUser() {
    // String result = "";
    // try {
    // ResultActions ra =
    // this.mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
    // .param("email", "test@test.com").param("passWord", "123"));
    // MvcResult mr = ra.andReturn();
    // result = mr.getResponse().getContentAsString();
    // } catch (Exception e) {
    // Assert.fail("fail");
    // e.printStackTrace();
    // }
    //
    // }

}
