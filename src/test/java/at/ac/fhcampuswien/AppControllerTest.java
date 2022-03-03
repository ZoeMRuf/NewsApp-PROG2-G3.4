package at.ac.fhcampuswien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class AppControllerTest {

    @Test
    public void filterListTest1(){
        Article a09 = new Article("Mama Wolowitz","Thursday is cancelled");
        Article a10 = new Article("Santa Clause","Bridge closure date: Thursday or October");
        Article a11 = new Article("Barry Allen","Safety meeting ends in accident");
        Article a12 = new Article("Amy B. McClaw","Murderer says detective ruined his reputation");
        Article a13 = new Article("john Smith","Utah Poison Control Center reminds everyone not to take poison");
        Article a14 = new Article("Wayne Hansen","Bugs flying around with wings are flying bugs");
        Article a15 = new Article("Princess Leia","Students Cook & Serve Grandparents");

        List<Article> withQueryList = new ArrayList<>();

        withQueryList.add(a09); withQueryList.add(a10); withQueryList.add(a11); withQueryList.add(a12);
        withQueryList.add(a13); withQueryList.add(a14); withQueryList.add(a15);

        String trueQuery = "Murderer";
        List<Article> actualFilterList = AppController.filterList(trueQuery,withQueryList);
        List<Article> expectedFilterList = new ArrayList<Article>();
        expectedFilterList.add(a12);

        assertEquals(actualFilterList.toString(), expectedFilterList.toString(), "query should be in the list");

    }

    @Test
    public void filterListTest2(){
        Article a01 = new Article("Caitlin Cleary","Forecasters call for weather on Monday");
        Article a02 = new Article("Scott Calvert","Cows lose their jobs as milk prices drop");
        Article a03 = new Article("Sheldon Cooper","Most Earthquake Damage is Caused by Shaking");
        Article a04 = new Article("Penny","Man Accused of Killing Lawyer Receives a New Attorney");
        Article a05 = new Article("Barbara Bitcoin","State population to double by 2040, babies to blame");
        Article a06 = new Article("Howard Wolowitz","Missippi's literacy program shows improvement");
        Article a07 = new Article("Leonard Hofstadter","Breathing oxygen linked to staying alive");
        Article a08 = new Article("me","Police arrest everyone on February 22nd");

        List<Article> withoutQueryList = new ArrayList<>();

        withoutQueryList.add(a01); withoutQueryList.add(a02); withoutQueryList.add(a03); withoutQueryList.add(a04);
        withoutQueryList.add(a05); withoutQueryList.add(a06); withoutQueryList.add(a07); withoutQueryList.add(a08);

        String trueQuery = "Murderer";
        List<Article> actualFilterList = AppController.filterList(trueQuery,withoutQueryList);
        List<Article> expectedFilterList = new ArrayList<Article>();

        assertEquals(actualFilterList.toString(), expectedFilterList.toString(), "query should not be in the list");

    }

}
