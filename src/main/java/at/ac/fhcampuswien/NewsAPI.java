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

    private static NewsAPI instance = null;

    private NewsAPI(){}

    public static NewsAPI getInstanceNewsAPI(){
        if (instance == null){
            instance = new NewsAPI();
        }
        return instance;
    }

    private static final String API_KEY = "f1838514139e4ec4af10d461c4b28119";

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String urlBuilder(Endpoint endpoint, Country coun, Language lang, Category cate, Sortby sort, String query){
        StringBuilder stb = new StringBuilder();
        stb.append("https://newsapi.org/v2/");

        if (endpoint == Endpoint.TOPHEADLINE){
            stb.append("top-headlines?country=");
            stb.append(coun.country);

            stb.append("&category=");
            stb.append(cate.category);
        }
        else {
            stb.append("everything?language=");
            stb.append(lang.language);

            stb.append("&sortby=");
            stb.append(sort.sortby);
        }

        if(query != null) {
            stb.append("&q=").append(query);
        }

        stb.append("&apiKey=");
        stb.append(API_KEY);

        return stb.toString();
    }

    public String urlBuilder(Country coun, Category cate, String query){
        StringBuilder stb = new StringBuilder();
        stb.append("https://newsapi.org/v2/");

        stb.append("top-headlines?country=");
        stb.append(coun.country);

        stb.append("&category=");
        stb.append(cate.category);


        stb.append("&q=").append(query);

        stb.append("&apiKey=");
        stb.append(API_KEY);

        return stb.toString();
    }

    public String urlBuilder(Language lang, Sortby sort, String query){
        StringBuilder stb = new StringBuilder();
        stb.append("https://newsapi.org/v2/");

        stb.append("everything?language=");
        stb.append(lang.language);

        stb.append("&sortby=");
        stb.append(sort.sortby);

        stb.append("&q=").append(query);

        stb.append("&apiKey=");
        stb.append(API_KEY);

        return stb.toString();
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

}

