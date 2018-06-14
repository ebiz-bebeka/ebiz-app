package models;

import java.util.ArrayList;

public class ShoesContModel {
    public static ArrayList<ShoesModel> shoes = new ArrayList<ShoesModel>();
    static
    {
        shoes.add(new ShoesModel(0, 20.00, "Baleriny 1", "/assets/img/shoes/baleriny_1a.jpg"));
        shoes.add(new ShoesModel(1, 20.00, "Baleriny 2", "/assets/img/shoes/baleriny_1b.jpg"));
        shoes.add(new ShoesModel(2, 30.00, "Espadryle", "/assets/img/shoes/k_espadryle_1a.jpg"));
        shoes.add(new ShoesModel(3, 5.00, "Klapki", "/assets/img/shoes/k_klapki_1a.jpg"));
        shoes.add(new ShoesModel(4, 15.00, "Sandały Damskie", "/assets/img/shoes/k_sandaly_1a.jpg"));
        shoes.add(new ShoesModel(5, 15.00, "Sportowe", "/assets/img/shoes/k_sportowe_1a.jpg"));
        shoes.add(new ShoesModel(6, 40.00, "Trampki 1", "/assets/img/shoes/k_trampki_1a.jpg"));
        shoes.add(new ShoesModel(7, 40.00, "Trampki 2", "/assets/img/shoes/k_trampki_1b.jpg"));
        shoes.add(new ShoesModel(8, 40.00, "Półbuty 1", "/assets/img/shoes/m_polbuty_2a.jpg"));
        shoes.add(new ShoesModel(9, 60.00, "Półbuty 2", "/assets/img/shoes/m_polbuty_1a.jpg"));
        shoes.add(new ShoesModel(10, 60.00, "Sandały Męskie", "/assets/img/shoes/m_sandaly_1a.jpg"));
        shoes.add(new ShoesModel(11, 40.00, "Trampki Męskie", "/assets/img/shoes/m_trampki_1a.jpg"));
    }
}
