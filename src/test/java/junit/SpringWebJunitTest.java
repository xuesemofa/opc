package junit;

import org.consume.com.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 单元测试 此为单元测试模版，如需要单元测试请完全按照正式java文件中的包路径自行新建自己的单元测试，请勿使用本类
 *
 * @author Administrator
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SpringWebJunitTest {

    // private final static Logger logger =
    // LoggerFactory.getLogger(SpringWebJunitTest.class);
    //
    // @Resource
    // private MenuService service;
    //
    // @Test
    // public void test() {
    //
    // List<MenuModel> list = service.findAll();
    // for (MenuModel m : list) {
    // logger.info(m.getMenu_url());
    // }
    // }
}