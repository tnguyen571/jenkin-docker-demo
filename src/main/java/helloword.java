import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {
        "com.webTemplate.config.web",  // MVC @Configuration
        "com.webTemplate.config.security", // Security @Configuration
        "com.webTemplate.config.jpa", // Database @Configuration -> does Entity Scan and Repository scan
        "com.webTemplate.service", // Service scan @Service
        "com.webTemplate.controler", // Controller scan @Controller
})
public class helloword {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(helloword.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8889"));
        app.run(args);
    }
    @GetMapping("/")
    public String sayHello() {
        return String.format("Hello %s!", "Change my request configure message");
    }

}
