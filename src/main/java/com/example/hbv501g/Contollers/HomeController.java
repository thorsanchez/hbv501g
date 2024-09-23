package com.example.hbv501g.Contollers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String HomeController(){
        //business logic
        //call a method in a Service Class
        //Add some data to the Model
        return "home";
    }

}
