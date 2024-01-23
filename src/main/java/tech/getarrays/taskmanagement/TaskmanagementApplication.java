package tech.getarrays.taskmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("tech.getarrays")
@ComponentScan("tech.getarrays")
@EnableJpaRepositories("tech.getarrays")
public class TaskmanagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskmanagementApplication.class, args);
	}

}
