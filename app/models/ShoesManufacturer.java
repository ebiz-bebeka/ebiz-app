package models;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoesManufacturer extends Model {

    @Id
    public Integer id;

    public String name;
    public String country;
}
