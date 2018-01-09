import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by satoshi on 2017/11/05.
 */

@RestController
@EnableAutoConfiguration
public class Example {

  public static void main(String... args) {
    SpringApplication.run(Example.class, args);
  }

  @RequestMapping("/")
  String home() {
    return "Hello World2!";
  }
}
