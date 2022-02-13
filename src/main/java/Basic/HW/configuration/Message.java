package Basic.HW.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@Getter
@PropertySource("classpath:app.properties")
public class Message {

    private String message;

    @Autowired
    public void Message(@Value("${myMessage}") String message) {
        this.message = message;
    }
}
