package org.consume.com.util.publics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicViewController {

    @GetMapping("/publics/{view}")
    public ModelAndView init(@PathVariable("view") String view) {
        return new ModelAndView("/publics/" + view);
    }
}
