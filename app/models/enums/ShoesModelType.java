package models.enums;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoesModelType extends Model {

    @Id
    public Integer id;

    public String name;
}
