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

    public void getArticleCountTest1(){
        Article a01 = new Article("Caitlin Cleary","Forecasters call for weather on Monday");
        Article a02 = new Article("Scott Calvert","Cows lose their jobs as milk prices drop");
        Article a03 = new Article("Sheldon Cooper","Most Earthquake Damage is Caused by Shaking");
        Article a04 = new Article("Penny","Man Accused of Killing Lawyer Receives a New Attorney");
        Article a05 = new Article("Barbara Bitcoin","State population to double by 2040, babies to blame");
        Article a06 = new Article("Howard Wolowitz","Missippi's literacy program shows improvement");
        Article a07 = new Article("Leonard Hofstadter","Breathing oxygen linked to staying alive");
        Article a08 = new Article("me","Police arrest everyone on February 22nd");

        //list of articles that replace the articles List in AppController
        List<Article> testList = new ArrayList<>();

        testList.add(a01); testList.add(a02); testList.add(a03); testList.add(a04);
        testList.add(a05); testList.add(a06); testList.add(a07); testList.add(a08);

        //creating an AppController Object so that we can test the getArticleCount() methode and change the article list
        AppController Controller = new AppController();
        Controller.setArticles(testList);

        //checking if the length of the testList we created is the same as the getArticleCount()
        assertEquals(testList.size(), Controller.getArticleCount());
    }

    @Test
    //Checks if the getArticleCount() methode returns 0, when the article list is null
    public void getArticleCountTest2(){
        List<Article> emptyList = null;
        AppController Controller = new AppController();

        Controller.setArticles(emptyList);
        assertEquals(Controller.getArticleCount(), 0);
    }



    @Test
    /*Creating a new AppController object to replace the article List with another list containing only one article,
    using the filterList() methode to find that article and check if it is the same as the new list we set it to*/
    public void setArticles1(){
        AppController Controller = new AppController();
        Article a01 = new Article("Caitlin Cleary","Forecasters call for weather on Monday");
        List<Article> testList = new ArrayList<>();
        testList.add(a01);

        Controller.setArticles(testList);
        String trueQuery = "call";
        assertEquals(testList, AppController.filterList(trueQuery,testList)); // ??? Controller statt AppController ???
    }

    @Test
    /* getAllNewsBitcoin tests if all articles with the query "bitcoin" are being returned */
    public void getAllNewsBitcoinTest1(){
        AppController Controller = new AppController();

        //added a list of articles with an article that includes the query "bitcoin" in the title
        Article a01 = new Article("Caitlin Cleary","Forecasters call for weather on Monday");
        Article a02 = new Article("Scott Calvert","Cows lose their jobs as milk prices drop");
        Article a03 = new Article("Sheldon Cooper","Most Earthquake Damage is Caused by Bitcoin");
        Article a04 = new Article("Penny","Man Accused of Killing Lawyer Receives a New Attorney");
        Article a05 = new Article("Barbara Bitcoin","State population to double by 2040, babies to blame");

        List<Article> testList = new ArrayList<>();
        testList.add(a01);
        testList.add(a02);
        testList.add(a03);
        testList.add(a04);
        testList.add(a05);

        Controller.setArticles(testList);

        //create a list with the article that includes the query "bitcoin" in the title
        //to check if the method getAllNewsBitcoin works
        List<Article> testLista03 = new ArrayList<>();
        testLista03.add(a03);

        //compares testLista03 with the getAllNewsBitcoin method
        assertEquals(testLista03, Controller.getAllNewsBitcoin());
    }

    @Test
    //to check if the method getTopHeadlinesAustria works
    public void getTopHeadlinesAustriaTest1()
    {
        //Create an object for accessing getTopHeadlinesAustria method from AppController.java
        AppController Controller = new AppController();

        //added a list of articles for testing
        Article a01 = new Article("Caecilia Smekal","Stadt Wolnowacha angeblich voellig zerstoert");
        Article a02 = new Article("Kiyoko Metzler","Russlands Armee rueckt weiter auf Kiew vor – Moskau droht mit Angriffen auf westliche Waffenlieferungen");
        Article a03 = new Article("Georg Hochmuth","Meinungsforscherin Sabine B. nannte Details zu SPOE-Auftraegen an Karmasin");
        Article a04 = new Article("Herbert Neubauer","Bluemel soll im Ibiza-U-Ausschuss Infos zum Alois-Mock-Institut unterdrueckt haben");
        Article a05 = new Article("Lara Hagen","Hure für die Reichen und Rote bleiben Gsindl: Das interaktive Archiv der Chatskandale");

        List<Article> testList = new ArrayList<>();
        testList.add(a01);
        testList.add(a02);
        testList.add(a03);
        testList.add(a04);
        testList.add(a05);

        //creak a testList
        Controller.setArticles(testList);

        //to check if the method getTopHeadlinesAustria works
        assertEquals(testList, Controller.getTopHeadlinesAustria());
    }

    @Test
    //Checks if the getTopHeadlinesAustria() methode returns an empty list, when the article list is null
    public void getTopHeadlinesAustriaTest2(){

        //Create an object for accessing getTopHeadlinesAustria method from AppController.java
        AppController Controller = new AppController();

        assertEquals(Controller.getTopHeadlinesAustria(), null); // test does not work !!!
    }
}
