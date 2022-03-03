package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Menu menu = new Menu(); //Instance of Menu to work with
        menu.start();

        Article a03 = new Article("Sheldon Cooper","Most Earthquake Damage is Caused by Shaking");

        List<Article> expectedFilterList = new ArrayList<Article>();

        System.out.println(expectedFilterList.toString());
    }


}
