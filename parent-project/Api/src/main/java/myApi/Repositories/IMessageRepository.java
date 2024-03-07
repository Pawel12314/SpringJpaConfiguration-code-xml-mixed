package myApi.Repositories;


import myApi.Models.Message;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan("myApi.Models")
public interface IMessageRepository extends CrudRepository<Message,Long> {
}
