package myApi.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="Message")

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String msg;
    public Message(String message)
    {
        this.msg = message;
    }
    public Message(){}
}
