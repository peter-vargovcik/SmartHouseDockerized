package vargovcik.peter.datacollector.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vargovcik.peter.datacollector.model.WeatherRecordModel;
import vargovcik.peter.datacollector.repo.WeatherRecordRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class RestService {
    private static final Logger log = LoggerFactory.getLogger(RestService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private WeatherRecordRepository repository;

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public ResponseEntity<?> getAccount() {
        List<WeatherRecordModel> records = repository.findAll();
        log.debug("accounts : {} ", records);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

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

    @RequestMapping("/findall")
    public List<WeatherRecordModel> findAll(){
        List<WeatherRecordModel> records = repository.findAll();

        return records;
    }
}