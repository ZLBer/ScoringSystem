package test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RESTController {
    @RequestMapping("/json")
    public String getJson(){
        return "Hello Spring Boot";
    }
}
