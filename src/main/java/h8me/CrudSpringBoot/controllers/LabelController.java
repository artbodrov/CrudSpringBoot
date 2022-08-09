package h8me.CrudSpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LabelController {

    @GetMapping("/label")
    public String sayHello(){

        return "/label";
    }
}
