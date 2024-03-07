package myServer;

import jakarta.transaction.Transactional;
import myApi.Models.Message;
import myApi.Repositories.IMessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import({myApi.Configs.ApplicationConfig.class})
@ComponentScan({"myApi.Repositories"})
@EntityScan("myApi.Models")
@EnableJpaRepositories({"myApi.Repositories"})
public class ApplicationAnnotationDriven {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationAnnotationDriven.class, args);
    }



    @Bean
    @Transactional
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {


        return args -> {
            IMessageRepository repo = ctx.getBean(IMessageRepository.class);
            repo.save(new Message("hello 123"));
            repo.save(new Message("hello 3456"));

            repo.findAll().forEach(item->System.out.println(item.msg));



        };
    }
}