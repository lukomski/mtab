package app.mtab;

import app.mtab.models.User;
import app.mtab.repositiories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MtabApplication {

//	private static final Logger log = LoggerFactory.getLogger(MtabApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MtabApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(UserRepository repository) {
//		return (args) -> {
//			repository.save(new User("Jack"));
//			repository.save(new User("Michael"));
//			log.info("saved mdfk");
//
//		};
//	}
}
