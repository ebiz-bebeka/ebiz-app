package controllers;

import play.mvc.*;
import views.html.*;

public class CartController extends Controller {
    public Result show() {
        return ok(basket.render("Panda3shoeS"));
    }
}
