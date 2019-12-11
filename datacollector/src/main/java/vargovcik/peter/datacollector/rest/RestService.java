package vargovcik.peter.datacollector.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class RestService {
    private static final Logger log = LoggerFactory.getLogger(RestService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @RequestMapping(value = "/")
    String hello() {

        System.out.println("Requested at : " + dateFormat.format(new Date()));
        log.info("Requested at : {}", dateFormat.format(new Date()));

        return "Hello World!";
    }

    @RequestMapping(value = "/test")
    String hello2() {
        return "Hello World Test That!";
    }
}