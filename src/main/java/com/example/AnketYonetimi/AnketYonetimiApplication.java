package com.example.AnketYonetimi;

import com.example.AnketYonetimi.dataAccess.UserRepository;
import com.example.AnketYonetimi.entities.Role;
import com.example.AnketYonetimi.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@ComponentScan(basePackages = "com.example.AnketYonetimi")
@SpringBootApplication
public class AnketYonetimiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AnketYonetimiApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	public  void run(String...args){
		User adminAccount=userRepository.findByRole(Role.ADMIN);
		if (null==adminAccount){
			User user=new User();
			user.setEmail("admin@admin.com");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setCity("Ankara");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
