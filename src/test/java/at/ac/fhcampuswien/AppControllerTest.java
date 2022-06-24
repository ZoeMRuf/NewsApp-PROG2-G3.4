package at.ac.fhcampuswien;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class AppControllerTest {

    private static AppController controller;
    private List<Article> testList;

    @BeforeEach
    void setup(){
        controller = AppController.getInstanceAppController();
        testList = AppController.generateMockList();
        controller.setArticles(testList);
    }

    @Test
    @DisplayName("filterListTest1: if the filtered List has the right size")

    public void filterListTest1(){
        String trueQuery = "Murderer";
        List<Article> actualFilterList = AppController.StreamFilterList(trueQuery,testList);
        assertEquals(1, actualFilterList.size());
    }

    @Test
    @DisplayName("filterListTest2: if there is only on right article.")

    public void filterListTest2(){
        Article a12 = new Article.Builder().author("Amy B. McClaw").title("Murderer says detective ruined his reputation").build();
        String trueQuery = "Murderer";
        List<Article> actualFilterList = AppController.StreamFilterList(trueQuery,testList); // -> using the Method that should be tested
        List<Article> expectedFilterList = new ArrayList<>(); // -> what we think the filtered list should give back
        expectedFilterList.add(a12);

        assertEquals(expectedFilterList.toString(), actualFilterList.toString());
    }

    @Test
    @DisplayName("filterListTest3: if the query exits more than once in the title, the article should still just be added once.")

    public void filterListTest3(){
        String trueQuery = "Bugs";
        List<Article> actualFilterList = AppController.StreamFilterList(trueQuery,testList); // -> using the Method that should be tested

        assertEquals(1, actualFilterList.size());
    }

    @Test
    @DisplayName("filterListTest4: if the query exits more than once in the title, the article should still just be added once.")

    public void filterListTest4(){
        Article a14 = new Article.Builder().author("Wayne Hansen").title("Bugs flying around with wings are flying bugs").build();
        String trueQuery = "Bugs";
        List<Article> actualFilterList = AppController.StreamFilterList(trueQuery,testList); // -> using the Method that should be tested
        List<Article> expectedFilterList = new ArrayList<>(); // -> what we think the filtered list should give back
        expectedFilterList.add(a14);

        assertEquals(expectedFilterList.toString(), actualFilterList.toString());
    }

    @Test
    @DisplayName("filterListTest5: if the query exists in more than one title all articles with the query should be added to the list.")

    public void filterListTest5(){
        String trueQuery = "to";
        List<Article> actualFilterList = AppController.StreamFilterList(trueQuery,testList); // -> using the Method that should be tested

        assertEquals(5, actualFilterList.size());
    }

    @Test
    @DisplayName("filterListTest6: if the query exists in more than one title all articles with the query should be added to the list.")

    public void filterListTest6(){



        Article a04 = new Article.Builder().author("Penny").title("Man Accused of Killing Lawyer Receives a New Attorney").build();
        Article a05 = new Article.Builder().author("Barbara Bitcoin").title("State population to double by 2040, babies to blame").build();
        Article a06 = new Article.Builder().author("Leonard Hofstadter").title("Breathing oxygen linked to staying alive").build();
        Article a07 = new Article.Builder().author("Santa Clause").title("Bridge closure date: Thursday or October").build();
        Article a08 = new Article.Builder().author("john Smith").title("Utah Poison Control Center reminds everyone not to take poison").build();


        String trueQuery = "to";
        List<Article> actualFilterList = AppController.StreamFilterList(trueQuery,testList); // -> using the Method that should be tested
        List<Article> expectedFilterList = new ArrayList<>(); // -> what we think the filtered list should give back

        expectedFilterList.add(a04); expectedFilterList.add(a05); expectedFilterList.add(a07);
        expectedFilterList.add(a06); expectedFilterList.add(a08);

        assertEquals(expectedFilterList.toString(), actualFilterList.toString());
    }

    @Test
    @DisplayName("filterListTest7: if the query is not found, no article should be added, therefore the list is empty.")

    public void filterListTest7(){
        String trueQuery = "xzy";
        List<Article> actualFilterList = AppController.StreamFilterList(trueQuery,testList); // -> using the Method that should be tested

        assertEquals(0,actualFilterList.size());
    }

    @Test
    @DisplayName("filterListTest8: if query is null")

    public void filterListTest8(){
        List<Article> actualFilterList = AppController.StreamFilterList(null, testList);
        assertEquals(0, actualFilterList.size());
    }

    @Test
    @DisplayName("filterListTest9: if list is null")

    public void filterListTest9(){
        List<Article> actualFilterList = AppController.StreamFilterList("A", null);
        assertEquals(0, actualFilterList.size());
    }

    @Test
    @DisplayName("filterListTest10: if list & query are null")

    public void filterListTest10(){
        List<Article> actualFilterList = AppController.StreamFilterList(null, null);
        assertEquals(0, actualFilterList.size());
    }

    @Test
    @DisplayName("getArticleCountTest1: tests if the articles inside the object have the right count")

    public void getArticleCountTest1(){
        int size = controller.getArticleCount();
        assertEquals(testList.size(), size);
    }

    @Test
    @DisplayName("getArticleCountTest2: Checks if the getArticleCount() methode returns 0, when the article list is null")

    public void getArticleCountTest2(){
        controller.setArticles(null);
        int size = controller.getArticleCount();
        assertEquals(0, size);
    }

    @Test
    @DisplayName("setArticleTest1: compares if article list(with getArticles) is the same size as the article size")

    public void setArticlesTest1(){
        assertEquals(controller.getArticles().size(), testList.size());
    }

    @Test
    @DisplayName("setArticleTest2: compares if article list(with getArticles) is the same as the article added")

    public void setArticlesTest2(){
        assertEquals(controller.getArticles(), testList);
    }

    @Test
    @DisplayName("getAllNewsBitcoinTest1: tests if the right amount of articles is filtered")

    public void getAllNewsBitcoinTest1(){
        List<Article> bitcoinArticles = controller.getAllNewsBitcoin();
        assertEquals(controller.getArticleCount(), bitcoinArticles.size());
    }

    /* Does not work because uses generateMockList
    @Test
    @DisplayName("getAllNewsBitcoinTest2: tests if all articles with the query \"bitcoin\" are being returned.")

    public void getAllNewsBitcoinTest2(){
        String expected = "Most Earthquake Damage is Caused by Shaking Bitcoin";

        List<Article> bitcoinArticles = controller.getAllNewsBitcoin();
        assertEquals(expected, bitcoinArticles.get(0).getTitle());
    } */

    @Test
    @DisplayName("getAllNewsBitcoinTest3: test that methode does not return null")

    public void getAllNewsBitcoinTest3(){
        controller.setArticles(null);
        List<Article> bitcoinArticles = controller.getAllNewsBitcoin();
        assertNotNull(bitcoinArticles);
    }

    /* Does not work because uses generateMockList
    @Test
    @DisplayName("getTopHeadlinesAustriaTest1: to check if the method getTopHeadlinesAustria works")

    public void getTopHeadlinesAustriaTest1() {
        assertEquals(testList, controller.getTopHeadlinesAustria());
    } */

    @Test
    @DisplayName("getTopHeadlinesAustriaTest2: Checks if the getTopHeadlinesAustria() methode returns an empty list, when the article list is null")
    
    public void getTopHeadlinesAustriaTest2(){
        controller.setArticles(null);
        assertNotNull(controller.getTopHeadlinesAustria());
    }
}
