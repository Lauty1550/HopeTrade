package is2.g57.hopetrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableAsync
public class HopetradeApplication {

    public static void main(String[] args) {
        // Carga variables del .env
        Dotenv dotenv = Dotenv.load();

        System.setProperty("MYSQL_HOST", dotenv.get("MYSQL_HOST"));
        System.setProperty("MYSQL_PORT", dotenv.get("MYSQL_PORT"));
        System.setProperty("MYSQL_DATABASE", dotenv.get("MYSQL_DATABASE"));
        System.setProperty("MYSQL_USER", dotenv.get("MYSQL_USER"));
        System.setProperty("MYSQL_PASSWORD", dotenv.get("MYSQL_PASSWORD"));

        SpringApplication.run(HopetradeApplication.class, args);
    }
}
