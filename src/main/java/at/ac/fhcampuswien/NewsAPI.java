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

    /* SINGELTON
    private static NewsAPI instance = null;

    private NewsAPI(){}

    public static NewsAPI getInstanceNewsAPI(){
        if (instance == null){
            instance = new NewsAPI();
        }
        return instance;
    }
     */

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

        int flag = 0;

        stb.append("https://newsapi.org/v2/");
        stb.append(this.endpoint+"?");
        if(this.endpoint.equals("top-headlines")){
            if(this.country != null && this.category!= null){
                stb.append("country="+ this.country);
                stb.append("&category="+ this.category);
                flag = 1;
            } else if (this.country != null){
                stb.append("country="+ this.country);
                flag = 1;
            }
            else if (this.category!= null){
                stb.append("category="+ this.category);
                flag = 1;
            }

        } else{ //endpoint = everything
            if(this.language != null && this.sortby!= null){
                stb.append("language="+ this.language);
                stb.append("&sortby="+ this.sortby);
                flag = 1;
            } else if (this.language != null){
                stb.append("language="+ this.language);
                flag = 1;
            }
            else if (this.sortby!= null){
                stb.append("sortby="+ this.sortby);
                flag = 1;
            }
        }

        if(this.query != null && flag == 0) {
            stb.append("q=").append(query);
        } else if(this.query != null && flag == 1){
            stb.append("&q=").append(query);
        }

        if(flag == 0) {
            stb.append("apiKey=").append(API_KEY);
        } else {
            stb.append("&apiKey=").append(API_KEY);
        }

        return stb.toString();
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
            this.endpoint = endpoint.toString();
        }

        public Builder country(Country country) {
            this.country = country.toString();
            return this;
        }

        public Builder language(Language language) {
            this.language = language.toString();
            return this;
        }

        public Builder category(Category category) {
            this.category = category.toString();
            return this;
        }

        public Builder sortby (Sortby sortby) {
            this.sortby = sortby.toString();
            return this;
        }

        public Builder query(String query){
            this.query = query.toString();
            return this;
        }

        public NewsAPI build(){
            return new NewsAPI(this);
        }
    }
}

