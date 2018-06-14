package controllers;

import models.CartModel;
import models.ShoesModel;
import models.UserDBModel;
import models.UserModel;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.formdata.LoginFormData;
import views.formdata.RegisterFormData;
import views.html.*;

import javax.inject.Inject;
import java.util.ArrayList;


public class StoreController extends Controller {

    @Inject FormFactory formFactory;

    public Result index() {
        return ok(homepage.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result login() {
        Form<LoginFormData> formData = formFactory.form(LoginFormData.class);
        return ok(login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }

    public Result register() {
        Form<RegisterFormData> formData = formFactory.form(RegisterFormData.class);
        return ok(register.render("Register", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }

    public Result postLogin() {

        // Get the submitted form data from the request object, and run validation.
        Form<LoginFormData> formData = formFactory.form(LoginFormData.class).bindFromRequest();

        if (formData.hasErrors()) {
            flash("error", "Login credentials not valid.");
            return redirect(routes.StoreController.info("Wrong email or password"));
        }
        else {
            // email/password OK, so now we set the session variable and only go to authenticated pages.
            session().clear();
            session("email", formData.get().email);
            return redirect(routes.StoreController.index());
        }
    }

    public Result postRegister() {

        // Get the submitted form data from the request object, and run validation.
        Form<RegisterFormData> formData = formFactory.form(RegisterFormData.class).bindFromRequest();

        if (formData.hasErrors()) {
            flash("error", "User exists.");
            return redirect(routes.StoreController.info("User exists"));
        }
        else {
            UserDBModel.addUserInfo(formData.get().name, formData.get().email, formData.get().password);
            CartModel.carts.put(formData.get().name, new ArrayList<ShoesModel>());
            return redirect(routes.StoreController.info("User " + formData.get().email + "Registered!"));
        }
    }

    @Security.Authenticated(Secured.class)
    public Result logout() {
        session().clear();
        return redirect(routes.StoreController.index());
    }

    @Security.Authenticated(Secured.class)
    public Result profile() {
        return ok(profile.render("Profile", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result info(String message)
    {
        return ok(infoPage.render(message, Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
}