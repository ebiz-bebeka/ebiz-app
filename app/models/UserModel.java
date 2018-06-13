package models;

import io.ebean.Model;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel extends Model {
    @Id
    public Integer id;
    public String username;
    public String password;
}
