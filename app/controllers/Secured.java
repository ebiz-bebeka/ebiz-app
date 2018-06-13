package controllers;

import models.UserModel;
import models.UserDBModel;
import play.mvc.Result;
import play.mvc.Security;
import play.mvc.Http.Context;


public class Secured extends Security.Authenticator {

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("email");
    }

    @Override
    public Result onUnauthorized(Context context) {
        return redirect(routes.StoreController.login());
    }

    public static String getUser(Context ctx) {
        return ctx.session().get("email");
    }

    public static boolean isLoggedIn(Context ctx) {
        return (getUser(ctx) != null);
    }

    public static UserModel getUserInfo(Context ctx) {
        return (isLoggedIn(ctx) ? UserDBModel.getUser(getUser(ctx)) : null);
    }
}