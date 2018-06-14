package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.formdata.LoginFormData;
import views.html.*;

import javax.inject.Inject;


public class StoreController extends Controller {

    @Inject FormFactory formFactory;

    public Result index() {
        return ok(homepage.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result login() {
        Form<LoginFormData> formData = formFactory.form(LoginFormData.class);
        return ok(login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }

    public Result postLogin() {

        // Get the submitted form data from the request object, and run validation.
        Form<LoginFormData> formData = formFactory.form(LoginFormData.class).bindFromRequest();

        if (formData.hasErrors()) {
            flash("error", "Login credentials not valid.");
            return badRequest(login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
        }
        else {
            // email/password OK, so now we set the session variable and only go to authenticated pages.
            session().clear();
            session("email", formData.get().email);
            return redirect(routes.StoreController.index());
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

}