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

    private static final String API_KEY = "f1838514139e4ec4af10d461c4b28119";

    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String urlBuilder(boolean topHeadlines, String country, String query){
        StringBuilder stb = new StringBuilder();
        stb.append("https://newsapi.org/v2/");

        if(topHeadlines){
            stb.append("top-headlines?country=");
            stb.append(country);
            stb.append("&q=");
        }else{
            stb.append("everything?");
            stb.append("q=");
        }

        stb.append(query);
        stb.append("&apiKey=");
        stb.append(API_KEY);

        return stb.toString();
    }

    public String urlBuilder(boolean topHeadlines, String query){
        StringBuilder stb = new StringBuilder();
        stb.append("https://newsapi.org/v2/");

        if(topHeadlines){
            stb.append("top-headlines?country=");
            stb.append("at");
            stb.append("&q=");
        }else{
            stb.append("everything?");
            stb.append("q=");
        }

        stb.append(query);
        stb.append("&apiKey=");
        stb.append(API_KEY);

        return stb.toString();
    }

    public String urlBuilder(boolean topHeadlines){
        StringBuilder stb = new StringBuilder();
        stb.append("https://newsapi.org/v2/");

        if(topHeadlines){
            stb.append("top-headlines?country=");
            stb.append("at");
        }else{
            stb.append("everything?");
        }

        stb.append("&apiKey=");
        stb.append(API_KEY);

        return stb.toString();
    }

    public static String urlBuilder(Endpoint endpoint, Country country, Language language, Category category, Sortby sortby){
        StringBuilder stb = new StringBuilder();
        stb.append("https://newsapi.org/v2/");

        if (endpoint == Endpoint.TOPHEADLINE){
            stb.append("top-headlines?country");

            switch (country){
                case UNITED_KINGDOM -> stb.append("=gb");
                case GERMANY ->  stb.append("=de");
                case AUSTRIA ->  stb.append("=at");
                case AUSTRALIA ->  stb.append("=au");
                case UNITED_STATES ->  stb.append("=us");
            }

            switch (category){
                case HEALTH -> stb.append("&category=health");
                case SPORTS -> stb.append("&category=sports");
                case GENERAL -> stb.append("&category=general");
                case SCIENCE -> stb.append("&category=science");
                case BUSINESS -> stb.append("&category=business");
                case TECHNOLOGY -> stb.append("&category=technology");
                case ENTERTAINMENT -> stb.append("&category=entertainment");
            }


        }
        else {
            stb.append("everything?");

            switch (language){
                case ARABIC -> stb.append("&language=ar");
                case DUTCH -> stb.append("&language=nl");
                case FRENCH -> stb.append("&language=fr");
                case German -> stb.append("&language=de");
                case HEBREW -> stb.append("&language=he");
                case SWEDEN -> stb.append("&language=se");
                case CHINESE -> stb.append("&language=zh");
                case ENGLISH -> stb.append("&language=en");
                case ITALIAN -> stb.append("&language=it");
                case RUSSIAN -> stb.append("&language=ru");
                case SPANISH -> stb.append("&language=es");
                case NORWEGIAN -> stb.append("&language=no");
                case PORTUGUESE -> stb.append("&language=pt");
            }

            switch (sortby){
                case RELEVANCY -> stb.append("&sortby=relevancy");
                case POPULARITY -> stb.append("&sortby=popularity");
                case PUBLISHEDAT -> stb.append("&sortby=publishedAt");
            }

        }

        stb.append("&apiKey=");
        stb.append(API_KEY);

        return stb.toString();
    }

    public List<Article> parsedArticle(String url) throws IOException {
        String jsonString = run(url);
        NewsResponse Response = gson.fromJson(jsonString, NewsResponse.class);
        return Response.getArticles();
    }

    public static void main(String[] args) {
        System.out.println(urlBuilder(Endpoint.EVERYTHING, Country.AUSTRIA, Language.German, Category.GENERAL, Sortby.PUBLISHEDAT));
    }

}

