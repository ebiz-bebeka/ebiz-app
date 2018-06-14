package controllers;

import models.CartModel;
import play.mvc.*;
import views.html.*;

public class CartController extends Controller {
    @Security.Authenticated(Secured.class)
    public Result cart() {

        return ok(basket.render("Cart", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    @Security.Authenticated(Secured.class)
    public Result addToCart(Integer id)
    {
        CartModel.addToCart(id, Secured.getUserInfo(ctx()).getName());
        return ok(homepage.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    @Security.Authenticated(Secured.class)
    public Result removeFromCart(Integer id)
    {
        CartModel.removeFromCart(id, Secured.getUserInfo(ctx()).getName());
        return ok(basket.render("Basket", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
}
