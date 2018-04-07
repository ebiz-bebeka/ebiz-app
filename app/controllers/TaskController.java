package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import views.html.*;
import models.Task;

import javax.inject.Inject;
import java.awt.print.Book;
import java.util.List;

public class TaskController extends Controller {
    @Inject FormFactory formFactory;

    public Result listAllTasks() {
        // Use these lines when Ebean & H2 are configured.
        // List<Task> tasks = Task.find.all();
        // return ok(list.render(tasks));
        return ok(list.render(Task.tasks));
    }

    public Result showTaskDetails(Long id) {
        return TODO;
    }

    public Result createTask() {
        Form<Task> taskForm = formFactory.form(Task.class);
        return ok(create.render(taskForm));
    }

    public Result deleteTask(Long id) {
        return TODO;
    }

    public Result save() {
        Task task = formFactory.form(Task.class).bindFromRequest().get();
        task.save();
        return redirect(routes.TaskController.listAllTasks());
    }

}
