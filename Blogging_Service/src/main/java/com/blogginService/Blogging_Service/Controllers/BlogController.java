package com.blogginService.Blogging_Service.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @GetMapping("/hello")
    public void helloMethod(){
        System.out.println("Hello from the controller");
    }
}
