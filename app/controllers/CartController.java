package controllers;

import play.mvc.*;
import views.html.*;

public class CartController extends Controller {
    @Security.Authenticated(Secured.class)
    public Result cart() {
        return ok(basket.render("Cart", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
}
