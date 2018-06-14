package models;

import java.util.ArrayList;
import java.util.List;

public class CartModel {
    public static ArrayList<ShoesModel> shoesInCart = new ArrayList<ShoesModel>();

    public static void addToCart(int id)
    {
        shoesInCart.add(ShoesContModel.shoes.get(id));
    }

    public static void removeFromCart(int index)
    {
        shoesInCart.remove(index);
    }

    public static double sum()
    {
        double sum = 0;
        for (ShoesModel shoe : shoesInCart)
        {
            sum += shoe.price;
        }
        return sum;
    }
}
