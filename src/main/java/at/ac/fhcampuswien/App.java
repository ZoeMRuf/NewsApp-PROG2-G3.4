package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Menu menu = new Menu(); //Instance of Menu to work with
        menu.start();


        Article a01 = new Article("Caitlin Cleary","Forecasters call for weather on Monday");
        Article a02 = new Article("Scott Calvert","Cows lose their jobs as milk prices drop");
        Article a03 = new Article("Sheldon Cooper","Most Earthquake Damage is Caused by Shaking");
        Article a04 = new Article("Penny","Man Accused of Killing Lawyer Receives a New Attorney");
        Article a05 = new Article("Barbara Bitcoin","State population to double by 2040, babies to blame");
        Article a06 = new Article("Howard Wolowitz","Missippi's literacy program shows improvement");
        Article a07 = new Article("Leonard Hofstadter","Breathing oxygen linked to staying alive");
        Article a08 = new Article("me","Police arrest everyone on February 22nd");

        List<Article> withoutQueryList = new ArrayList<>(); // -> list of articles without the query among them

        withoutQueryList.add(a01); withoutQueryList.add(a02); withoutQueryList.add(a03); withoutQueryList.add(a04);
        withoutQueryList.add(a05); withoutQueryList.add(a06); withoutQueryList.add(a07); withoutQueryList.add(a08);

        System.out.println(withoutQueryList);



    }


}
