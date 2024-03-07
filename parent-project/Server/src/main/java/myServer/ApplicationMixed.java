package myServer;

import myApi.Models.Message;
import myApi.Repositories.IMessageRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
@Import({myApi.Configs.ApplicationConfig.class})
@ComponentScan({"myApi.Repositories"})
@EntityScan("myApi.Models")

public class ApplicationMixed {

    // @Transactional
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello from main function");
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("mymixedrepositorybeans.xml");
        ctx.registerShutdownHook();

        IMessageRepository repo = ctx.getBean(IMessageRepository.class);
        repo.save(new Message("hello mixed_1"));
        repo.save(new Message("hello mixed_2"));
        repo.findAll().forEach(item->System.out.println(item.msg));
    }
}
