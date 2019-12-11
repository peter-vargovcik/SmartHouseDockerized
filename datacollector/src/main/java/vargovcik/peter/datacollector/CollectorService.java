package vargovcik.peter.datacollector;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CollectorService {

    public static void main(String[] args) {
        SpringApplication.run(CollectorService.class);
    }
}
