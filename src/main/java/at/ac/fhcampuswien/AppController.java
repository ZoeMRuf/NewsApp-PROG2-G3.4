package at.ac.fhcampuswien;

import java.util.List;

public class AppController {
    private List<Article> articles;

    //Constructor for this Class
    public AppController(){}

    //Methods
    public  void setArticles(List <Article> articles){}

    public int getArticleCount(){
        return 42;
    }

    public List<Article> getTopHeadlinesAustria(){}

    public  List<Article> getAllNewsBitcoin(){}

    //filter that can only be used in this Class -> useful for getTopHeadlinesAustria & getAllNewsBitcoin
    protected static List<Article> filterList(String query, List<Article> articles){}

    private List<Article> generateMockList(){}

}
