package controllers;

import play.mvc.*;
import views.html.*;

public class StoreController extends Controller {
    public Result showStore() {
        return ok(index.render("Panda3shoeS"));
    }
}
