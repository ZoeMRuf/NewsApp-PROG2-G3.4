package at.ac.fhcampuswien;

import API_Enums.*;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;

import java.io.IOException;

public class NewsAPI {

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    private static final String API_KEY = "f1838514139e4ec4af10d461c4b28119";

    private final String endpoint;
    private final String country;
    private final String language;
    private final String category;
    private final String sortby;
    private final String query;


    private NewsAPI(Builder builder){
        this.endpoint = builder.endpoint;
        this.country = builder.country;
        this.language = builder.language;
        this.category = builder.category;
        this.sortby = builder.sortby;
        this.query = builder.query;
    }

    public String urlBuilder(){
        StringBuilder stb = new StringBuilder();
        int flag = 0; //So the If-Conditions vor Query and ApiKey are easier

        stb.append("https://newsapi.org/v2/"); // Star of every URL always appended
        stb.append(this.endpoint).append("?"); // There must always be an endpoint, so just append it to the String

        // If-Condition for the two different Endpoint -> here TopHeadlines
        if(this.endpoint.equals("top-headlines")){

            // If country & category are given they must be appended with a "&" to separate them
            if(this.country != null && this.category!= null){
                stb.append("country=").append(this.country);
                stb.append("&category=").append(this.category);
                flag = 1; // Flag is set if anything is appended to the String after the Endpoint
            }
            // first else-if -> if only country is given (it is appended to the String without the "&")
            else if (this.country != null){
                stb.append("country=").append(this.country);
                flag = 1; // Flag is set if anything is appended to the String after the Endpoint
            }
            // second else-if -> if only category is given (it is appended to the String without the "&")
            else if (this.category!= null){
                stb.append("category=").append(this.category);
                flag = 1; // Flag is set if anything is appended to the String after the Endpoint
            }

        }
        // If Endpoint is NOT TopHeadlines it must be -> Everything
        else{
            // If language & sortby are given they must be appended with a "&" to separate them
            if(this.language != null && this.sortby!= null){
                stb.append("language=").append(this.language);
                stb.append("&sortby=").append(this.sortby);
                flag = 1; // Flag is set if anything is appended to the String after the Endpoint
            }
            // first else-if -> if only language is given (it is appended to the String without the "&")
            else if (this.language != null){
                stb.append("language=").append(this.language);
                flag = 1; // Flag is set if anything is appended to the String after the Endpoint
            }
            // second else-if -> if only sortby is given (it is appended to the String without the "&")
            else if (this.sortby!= null){
                stb.append("sortby=").append(this.sortby);
                flag = 1; // Flag is set if anything is appended to the String after the Endpoint
            }
        }

        // If only Endpoint (Mandatory) and the Query are given (flag is still 0), append Query without the "&"
        if (this.query != null && flag == 0) {
            stb.append("q=").append(query);
            flag = 1; // Flag is set if anything is appended to the String after the Endpoint
        }
        // If query is given and flag is 1 append query with "&" to separate it form the other parameters
        else if (this.query != null && flag == 1){
            stb.append("&q=").append(query);
        }

        // If Flag is 0 nothing was appended to the Endpoint the ApiKey can be appended without an "&"
        if (flag == 0) {
            stb.append("apiKey=").append(API_KEY);
        }
        // Else the "&" is needed
        else {
            stb.append("&apiKey=").append(API_KEY);
        }

        return stb.toString(); // Make StringBuilder to String
    }

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public List<Article> parsedArticle(String url) throws NewAPIException{
        try {
            String jsonString = run(url);
            NewsResponse Response = gson.fromJson(jsonString, NewsResponse.class);
            return Response.getArticles();
        }
        catch (IOException e){
            throw new NewAPIException("Problem with run Method");
        }
    }

    public int parsedTotalResults(String url) throws NewAPIException {
        try {
            String jsonString = run(url);
            NewsResponse Response = gson.fromJson(jsonString, NewsResponse.class);
            return Response.getTotalResults();
        }
        catch(IOException e){
            throw new NewAPIException("Problem with run Method");
        }
    }

    public String parsedStatus(String url) throws NewAPIException {
        try {
            String jsonString = run(url);
            NewsResponse Response = gson.fromJson(jsonString, NewsResponse.class);
            return Response.getStatus();
        }
        catch(IOException e){
            throw new NewAPIException("Problem with run Method");
        }
    }

    public static class Builder{
        private final String endpoint;
        private String country;
        private String language;
        private String category;
        private String sortby;
        private String query;

        public Builder(Endpoint endpoint){
            this.endpoint = endpoint.endpoint;
        }

        public Builder country(Country country) {
            this.country = country.country;
            return this;
        }

        public Builder language(Language language) {
            this.language = language.language;
            return this;
        }

        public Builder category(Category category) {
            this.category = category.category;
            return this;
        }

        public Builder sortby (Sortby sortby) {
            this.sortby = sortby.sortby;
            return this;
        }

        public Builder query(String query){
            this.query = query;
            return this;
        }

        public NewsAPI build(){
            return new NewsAPI(this);
        }
    }

}

