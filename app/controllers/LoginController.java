package controllers;

import play.mvc.*;
import views.html.*;

public class LoginController extends Controller {
    public Result show() {
        return ok(login.render("Panda3shoeS"));
    }
}
