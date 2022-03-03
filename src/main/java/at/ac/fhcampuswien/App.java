package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Menu menu = new Menu(); //Instance of Menu to work with
        menu.start();

        Article a08 = new Article("me","Police arrest everyone on February 22nd");
        List<Article> expectedFilterList = new ArrayList<Article>();
        expectedFilterList.add(a08);

        System.out.println(expectedFilterList);


    }


}
