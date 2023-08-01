package ru.netology.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCrypt;
//import javax.validation.Valid;


import ru.netology.repository.UserRepository;
import ru.netology.authority.Authorities;
import java.util.Arrays;
import java.util.List;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	private static final List<Authorities> aclr = Arrays.asList(Authorities.valueOf("READ"));
	private static final List<Authorities> aclrw = Arrays.asList(Authorities.valueOf("READ"),
			Authorities.valueOf("WRITE"));
	private static final List<Authorities> aclrwd = Arrays.asList(Authorities.valueOf("READ"),
			Authorities.valueOf("WRITE"), Authorities.valueOf("DELETE"));

	@Bean
	CommandLineRunner initDatabase(UserRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(0, "ivan", BCrypt.hashpw("qwerty123", BCrypt.gensalt()), aclr).toString());

			log.info("Preloading " + repository.save(0, "oleg", BCrypt.hashpw("welcome1", BCrypt.gensalt()), aclrw).toString());

			log.info("Preloading " + repository.save(0, "masha", BCrypt.hashpw("Welcome1!", BCrypt.gensalt()), aclrwd).toString());
		};
	}
}
