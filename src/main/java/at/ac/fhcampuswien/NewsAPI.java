package at.ac.fhcampuswien;

import java.io.IOException;

public class NewsAPI {

    private static final String API_KEY = "f1838514139e4ec4af10d461c4b28119";

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String urlBuilder(boolean topHeadlines, String country, String query){
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

    public static String urlBuilder(boolean topHeadlines, String query){
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
}
