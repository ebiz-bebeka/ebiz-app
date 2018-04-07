package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Task extends Model {

    enum Priority { LOW, NORMAL, HIGH }

    @Id
    public Long id;
    public String description;
    public Priority priority;
    public Boolean done;

    public Task(long id, String description, Priority priority, boolean done) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.done = done;
    }

    public static final Finder<Long, Task> find = new Finder<>(Task.class);


    // Dummy static list of tasks.
    // TODO: Replace with an actual H2 database.
    public static List<Task> tasks;

    static {
        tasks = new ArrayList<>();
        tasks.add(new Task(1, "Buy vegetable for the dinner", Priority.NORMAL, false));
        tasks.add(new Task(2, "Buy wine for the dinner",  Priority.HIGH, false));
        tasks.add(new Task(3, "Feed the cat", Priority.HIGH, false));
        tasks.add(new Task(4, "Push the EBCT project to GitHub", Priority.LOW, true));
        tasks.add(new Task(5, "Make the project look nice with Bootstrap", Priority.LOW, false));
    }

}
