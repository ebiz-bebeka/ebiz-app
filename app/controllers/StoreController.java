package controllers;

import play.mvc.*;
import views.html.*;

public class StoreController extends Controller {
    public Result showHomepage() {
        return ok(homepage.render("Panda3shoeS"));
    }
}
