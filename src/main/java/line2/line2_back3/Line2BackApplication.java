package line2.line2_back3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class Line2BackApplication {

    public static void main(String[] args) {
        SpringApplication.run(Line2BackApplication.class, args);
    }
	
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
