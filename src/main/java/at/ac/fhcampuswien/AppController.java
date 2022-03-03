package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    private List<Article> articles = generateMockList(); // For us to test the Methods.

    //Constructor for this Class
    public AppController(){}

    //Methods
    public void setArticles(List <Article> articles){}

    public int getArticleCount(){
        return 42;
    }

    public List<Article> getTopHeadlinesAustria(){
        return articles;
    }

    public List<Article> getAllNewsBitcoin(){
        return articles;
    }

    //filter that can only be used in this Class -> useful for getTopHeadlinesAustria & getAllNewsBitcoin
    protected static List<Article> filterList(String query, List<Article> articles){
        List<Article> filteredList = new ArrayList();

        for (int i = 0; i < articles.size(); i++) {
            Article toFilter = articles.get(i);
            String articleTitle = toFilter.getTitle();
            String[] splitTitle = articleTitle.split(" ");

            for (int j = 0; j < splitTitle.length; j++) {
                if (filteredList.contains(toFilter)){
                    break;
                }
                else if (splitTitle[j].equalsIgnoreCase(query)){
                    filteredList.add(toFilter);
                }
            }
        }
        return filteredList;
    }

    private List<Article> generateMockList(){

        Article a01 = new Article("Caitlin Cleary","Forecasters call for weather on Monday");
        Article a02 = new Article("Scott Calvert","Cows lose their jobs as milk prices drop");
        Article a03 = new Article("Sheldon Cooper","Most Earthquake Damage is Caused by Shaking");
        Article a04 = new Article("Penny","Man Accused of Killing Lawyer Receives a New Attorney");
        Article a05 = new Article("Barbara Bitcoin","State population to double by 2040, babies to blame");
        Article a06 = new Article("Howard Wolowitz","Missippi's literacy program shows improvement");
        Article a07 = new Article("Leonard Hofstadter","Breathing oxygen linked to staying alive");
        Article a08 = new Article("me","Police arrest everyone on February 22nd");
        Article a09 = new Article("Mama Wolowitz","Thursday is cancelled");
        Article a10 = new Article("Santa Clause","Bridge closure date: Thursday or October");
        Article a11 = new Article("Barry Allen","Safety meeting ends in accident");
        Article a12 = new Article("Amy B. McClaw","Murderer says detective ruined his reputation");
        Article a13 = new Article("john Smith","Utah Poison Control Center reminds everyone not to take poison");
        Article a14 = new Article("Wayne Hansen","Bugs flying around with wings are flying bugs");
        Article a15 = new Article("Princess Leia","Students Cook & Serve Grandparents");

        List<Article> MockList = new ArrayList<>();

        MockList.add(a01); MockList.add(a02); MockList.add(a03); MockList.add(a04); MockList.add(a05);
        MockList.add(a06); MockList.add(a07); MockList.add(a08); MockList.add(a09); MockList.add(a10);
        MockList.add(a11); MockList.add(a12); MockList.add(a13); MockList.add(a14); MockList.add(a15);

        return MockList;
    }

}
