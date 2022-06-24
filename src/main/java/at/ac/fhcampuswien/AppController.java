package at.ac.fhcampuswien;

import API_Enums.*;
import java.util.*;
import java.util.stream.Collectors;

public class AppController {
    private List<Article> articles;
    NewsAPI news = new NewsAPI();

    private static AppController instance = null;

    // Empty Constructor
    private AppController(){}

    // public way to get to our private AppController instance -> Singleton
    public static AppController getInstanceAppController() {
        if (instance == null){
            instance = new AppController();
        }
        return instance;
    }

    //Getter & Setter for articles
    public void setArticles(List <Article> articles){
        this.articles = articles;
    }

    public List<Article> getArticles(){
        return this.articles;
    }

    public int getArticleCount(){
        if(this.articles == null){
            return 0;
        }
        return this.articles.size();
    }

    //main AppController Methods
    public List<Article> getTopHeadlinesAustria(){
        try{
            articles = news.parsedArticle(news.urlBuilder(Country.AUSTRIA, Category.GENERAL, "corona"));
        }
        catch (NullPointerException | NewAPIException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
        return articles;
    }

    public List<Article> getAllNewsBitcoin(){
        try{
            articles = news.parsedArticle(news.urlBuilder(Language.GERMAN, Sortby.PUBLISHED_AT, "bitcoin"));
        }
        catch (NullPointerException | NewAPIException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
        return articles;
    }

    public String getMostPopularSources(){

        /*
        Source: https://stackoverflow.com/questions/69608912/java-stream-find-most-frequent-element-based-on-a-specific-field
         */

        String mostSourceName = "";
        int SourceFrequency = 0;
        Map<String, Integer> map = new HashMap<>();

        for (Article a : articles){
            if (map.merge(a.getSourceName(), 1, Integer::sum) > SourceFrequency){
                SourceFrequency = map.get(a.getSourceName());
                mostSourceName = a.getSourceName();
            }
        }
        return mostSourceName;
    }

    public String getLongestAuthorName(){
        try{
            return articles.stream().max(Comparator.comparingInt(Article::getAuthorLength)).orElse(null).getAuthor();
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
            return "There is no author";
        }
    }

    public int getNewYorkTimesArticleCount(){
        List<Article> streamedArticle = articles.stream()
                .filter(article -> article.getSourceName().toLowerCase().contains("newyorktimes"))
                .collect(Collectors.toList());
        return streamedArticle.size();
    }

    public List<Article> getShortHeadlines(){
        return articles.stream().filter(article -> article.getTitle().length() < 15).collect(Collectors.toList());
    }

    public List<Article> sortedByDescription(){

        /*
        Source: https://howtodoinjava.com/java/sort/sort-on-multiple-fields/
         */

        Comparator<Article> sortByLength = Comparator.comparingInt(Article::getDescriptionLength);
        Comparator<Article> sortByAlphabet = Comparator.comparing(Article::getDescription);

        Comparator<Article> sortedByLengthAndAlphabet = sortByLength.thenComparing(sortByAlphabet);

        return articles.stream().sorted(sortedByLengthAndAlphabet).collect(Collectors.toList());
    }

    public List<Article> getConfiguredArticles(Endpoint endpoint, Country coun, Language lang, Category cate, Sortby sort, String query){
        try{
            articles = news.parsedArticle(news.urlBuilder(endpoint, coun, lang, cate, sort, query));
        }
        catch (NullPointerException | NewAPIException e){
            System.out.println(e.getMessage());
        }

        if (articles == null){
            return new ArrayList<>();
        }
        return articles;
    }

    //Stream Filter
    protected static List<Article> StreamFilterList(String query, List<Article> articles){
        if (query != null && articles != null){
            return articles.stream()
                    .filter(article -> article.getTitle().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());
        }
        else {
            return new ArrayList<>();
        }
    }

    //filter that is addressed over the package -> useful for getTopHeadlinesAustria & getAllNewsBitcoin
    protected static List<Article> filterList(String query, List<Article> articles){

        if (query != null && articles != null){

            List<Article> filteredList = new ArrayList();

            //for-loop to go through all articles in the list
            for (int i = 0; i < articles.size(); i++) {
                Article toFilter = articles.get(i);
                String articleTitle = toFilter.getTitle(); // -> to get only the title of the article
                String[] splitTitle = articleTitle.split(" "); // -> to get all the words of the title

                //for-loop to go through all the words
                for (int j = 0; j < splitTitle.length; j++) {
                    //if-condition to skip the title if it is already in the list
                    if (filteredList.contains(toFilter)){
                        break;
                    }
                    //if-condition to compare the query with the words
                    else if (splitTitle[j].toLowerCase().contains(query.toLowerCase())){
                        //.equalsIgnoreCase(query) -> searches only for the whole word not just parts
                        filteredList.add(toFilter);
                    }
                }
            }
            return filteredList;
        }
        else {
            return new ArrayList<>();
        }
    }

    public static List<Article> generateMockList(){

        Article a01 = new Article("Caitlin Cleary","Forecasters call for weather on Monday");
        Article a02 = new Article("Scott Calvert","Cows lose their jobs as milk prices drop");
        Article a03 = new Article("Sheldon Cooper","Most Earthquake Damage is Caused by Shaking Bitcoin");
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
