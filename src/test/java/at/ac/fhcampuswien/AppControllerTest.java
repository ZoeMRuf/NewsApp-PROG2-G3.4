package at.ac.fhcampuswien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class AppControllerTest {

    @Test
    /* test if the right article is filter out of the list part 1:
        if there is only on right article. */
    public void filterListTest1(){
        Article a09 = new Article("Mama Wolowitz","Thursday is cancelled");
        Article a10 = new Article("Santa Clause","Bridge closure date: Thursday or October");
        Article a11 = new Article("Barry Allen","Safety meeting ends in accident");
        Article a12 = new Article("Amy B. McClaw","Murderer says detective ruined his reputation");
        Article a13 = new Article("john Smith","Utah Poison Control Center reminds everyone not to take poison");
        Article a14 = new Article("Wayne Hansen","Bugs flying around with wings are flying bugs");
        Article a15 = new Article("Princess Leia","Students Cook & Serve Grandparents");

        List<Article> withQueryList = new ArrayList<>(); // -> list of articles with the query among them

        withQueryList.add(a09); withQueryList.add(a10); withQueryList.add(a11); withQueryList.add(a12);
        withQueryList.add(a13); withQueryList.add(a14); withQueryList.add(a15);

        String trueQuery = "Murderer";
        List<Article> actualFilterList = AppController.filterList(trueQuery,withQueryList); // -> using the Method that should be tested
        List<Article> expectedFilterList = new ArrayList<Article>(); // -> what we think the filtered list should give back
        expectedFilterList.add(a12);

        //the actual Test
        if (actualFilterList.size() != expectedFilterList.size()){
            assertEquals(expectedFilterList.size(), actualFilterList.size()); // -> test if size is the same
        }
        else {
            for (int i = 0; i < actualFilterList.size(); i++) {
                assertEquals(expectedFilterList.get(i), actualFilterList.get(i), "query should be in the list"); // -> test if content is the same
            }
        }
    }

    @Test
    /* test if the right article is filter out of the list part 2:
        if the query exits more than once in the title, the article should still just be added once. */
    public void filterListTest2(){
        Article a09 = new Article("Mama Wolowitz","Thursday is cancelled");
        Article a10 = new Article("Santa Clause","Bridge closure date: Thursday or October");
        Article a11 = new Article("Barry Allen","Safety meeting ends in accident");
        Article a12 = new Article("Amy B. McClaw","Murderer says detective ruined his reputation");
        Article a13 = new Article("john Smith","Utah Poison Control Center reminds everyone not to take poison");
        Article a14 = new Article("Wayne Hansen","Bugs flying around with wings are flying bugs");
        Article a15 = new Article("Princess Leia","Students Cook & Serve Grandparents");

        List<Article> withQueryList = new ArrayList<>(); // -> list of articles with the query among them

        withQueryList.add(a09); withQueryList.add(a10); withQueryList.add(a11); withQueryList.add(a12);
        withQueryList.add(a13); withQueryList.add(a14); withQueryList.add(a15);

        String trueQuery = "Bugs";
        List<Article> actualFilterList = AppController.filterList(trueQuery,withQueryList); // -> using the Method that should be tested
        List<Article> expectedFilterList = new ArrayList<Article>(); // -> what we think the filtered list should give back
        expectedFilterList.add(a14);

        //the actual Test
        if (actualFilterList.size() != expectedFilterList.size()){
            assertEquals(expectedFilterList.size(), actualFilterList.size()); // -> test if size is the same
        }
        else {
            for (int i = 0; i < actualFilterList.size(); i++) {
                assertEquals(expectedFilterList.get(i), actualFilterList.get(i), "query should be in the list"); // -> test if content is the same
            }
        }
    }

    @Test
    /* test if the right article is filter out of the list part 3:
        if the query exists in more than one title all articles with the query should be added to the list. */
    public void filterListTest3(){
        Article a01 = new Article("Caitlin Cleary","Forecasters call for weather on Monday");
        Article a02 = new Article("Scott Calvert","Cows lose their jobs as milk prices drop");
        Article a03 = new Article("Sheldon Cooper","Most Earthquake Damage is Caused by Shaking");
        Article a04 = new Article("Penny","Man Accused of Killing Lawyer Receives a New Attorney");
        Article a05 = new Article("Barbara Bitcoin","State population to double by 2040, babies to blame");
        Article a06 = new Article("Howard Wolowitz","Missippi's literacy program shows improvement");
        Article a07 = new Article("Leonard Hofstadter","Breathing oxygen linked to staying alive");
        Article a08 = new Article("me","Police arrest everyone on February 22nd");

        List<Article> withQueryList = new ArrayList<>(); // -> list of articles with the query among them

        withQueryList.add(a01); withQueryList.add(a02); withQueryList.add(a03); withQueryList.add(a04);
        withQueryList.add(a05); withQueryList.add(a06); withQueryList.add(a07); withQueryList.add(a08);

        String trueQuery = "to";
        List<Article> actualFilterList = AppController.filterList(trueQuery,withQueryList); // -> using the Method that should be tested
        List<Article> expectedFilterList = new ArrayList<Article>(); // -> what we think the filtered list should give back
        expectedFilterList.add(a05); expectedFilterList.add(a07);

        //the actual Test
        if (actualFilterList.size() != expectedFilterList.size()){
            assertEquals(expectedFilterList.size(), actualFilterList.size()); // -> test if size is the same
        }
        else {
            for (int i = 0; i < actualFilterList.size(); i++) {
                assertEquals(expectedFilterList.get(i), actualFilterList.get(i), "query should be in the list"); // -> test if content is the same
            }
        }
    }

    @Test
    /* test if an empty list is given back if there is no right article part 1:
        if the query is not found, no article should be added, therefore the list is empty. */
    public void filterListTest4(){
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

        String trueQuery = "Murderer";
        List<Article> actualFilterList = AppController.filterList(trueQuery,withoutQueryList); // -> using the Method that should be tested
        List<Article> expectedFilterList = new ArrayList<Article>(); // -> an empty list (this should be the solution)

        //the actual Test
        if (actualFilterList.size() != expectedFilterList.size()){
            assertEquals(expectedFilterList.size(), actualFilterList.size()); // -> test if size is the same
        }
        else {
            for (int i = 0; i < actualFilterList.size(); i++) {
                assertEquals(expectedFilterList.get(i), actualFilterList.get(i), "query should not be in the list"); // -> test if content is the same
            }
        }
    }

    @Test

    public void getArticleCount1(){
        Article a01 = new Article("Caitlin Cleary","Forecasters call for weather on Monday");
        Article a02 = new Article("Scott Calvert","Cows lose their jobs as milk prices drop");
        Article a03 = new Article("Sheldon Cooper","Most Earthquake Damage is Caused by Shaking");
        Article a04 = new Article("Penny","Man Accused of Killing Lawyer Receives a New Attorney");
        Article a05 = new Article("Barbara Bitcoin","State population to double by 2040, babies to blame");
        Article a06 = new Article("Howard Wolowitz","Missippi's literacy program shows improvement");
        Article a07 = new Article("Leonard Hofstadter","Breathing oxygen linked to staying alive");
        Article a08 = new Article("me","Police arrest everyone on February 22nd");

        List<Article> testList = new ArrayList<>(); // -> list of articles without the query among them

        testList.add(a01); testList.add(a02); testList.add(a03); testList.add(a04);
        testList.add(a05); testList.add(a06); testList.add(a07); testList.add(a08);

        AppController Controller = new AppController();
        Controller.setArticles(testList);
        assertEquals(testList.size(), Controller.getArticleCount());
    }

    @Test


    public void getArticleCount2(){
        List<Article> emptyList = null;
        AppController Controller = new AppController();

        Controller.setArticles(emptyList);
        assertEquals(Controller.getArticleCount(), 0);
    }

    @Test

    public void setArticles1(){
        AppController Controller = new AppController();
        Article a01 = new Article("Caitlin Cleary","Forecasters call for weather on Monday");
        List<Article> testList = new ArrayList<>();
        testList.add(a01);

        Controller.setArticles(testList);
        String trueQuery = "call";
        assertEquals(testList, AppController.filterList(trueQuery,testList));
    }
}
