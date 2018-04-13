package org.consume.com.index;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String init() {
        return "<a href='http://localhost:8089/opc/tb'>测试同步</a><br/>" +
                "<a href='http://localhost:8089/opc/sd'>测试水</a><br/>"+
                "<a href='http://localhost:8089/opc/sd2'>测试电</a><br/>";
    }

}
