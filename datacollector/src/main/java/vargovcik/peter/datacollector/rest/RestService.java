package vargovcik.peter.datacollector.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
public class RestService {
    public static void main(String[] args) {
        SpringApplication.run(RestService.class, args);
    }

    @RequestMapping(value = "/")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/test")
    String hello2() {
        return "Hello World Test That!";
    }
}