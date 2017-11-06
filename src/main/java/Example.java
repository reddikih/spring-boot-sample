import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by satoshi on 2017/11/05.
 */

@RestController
@EnableAutoConfiguration
public class Example {

	@RequestMapping("/")
	String home() {
		return "Hello World2!";
	}

	public static void main(String... args) {
		SpringApplication.run(Example.class, args);
	}
}
