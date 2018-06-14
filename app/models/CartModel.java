package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartModel {

    public static Map<String, ArrayList<ShoesModel>> carts = new HashMap<String, ArrayList<ShoesModel>>();
    static
    {
        for (Map.Entry<String, UserModel> user : UserDBModel.userinfos.entrySet())
        {
            carts.put(user.getValue().getName(), new ArrayList<ShoesModel>());
        }
    }

    public static void addToCart(int id, String user)
    {
        carts.get(user).add(ShoesContModel.shoes.get(id));
    }

    public static void removeFromCart(int index, String user)
    {
        carts.get(user).remove(index);
    }

    public static double sum(String user)
    {
        double sum = 0;
        for (ShoesModel shoe : carts.get(user))
        {
            sum += shoe.price;
        }
        return sum;
    }
}
