package lt.codeacademy.eShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class MyFirstController {

    @GetMapping
    public ModelAndView hello() {
        ModelAndView model = new ModelAndView("firstTemplate");
        return model;
    }

    @GetMapping("/secondExample/{name}")
    public String secondMethod(@PathVariable("name") String myName, @RequestParam(required = false) String param) {
        System.out.println(myName);
        return "firstTemplate";
    }
}
