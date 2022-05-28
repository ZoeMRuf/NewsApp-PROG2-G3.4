package at.ac.fhcampuswien;

public class Article {
    //Attributes
    private String author;
    private String title;
    private String description;
    private String content;
    private Source source;
    private String url;
    private String urlToImage;
    private String publishedAt;

    //Constructor for this Class
    public Article(String author, String title){
        this.author = author;
        this.title = title;
    }

    public Article(String author, String title, String description, Source source, String url, String urlToImage, String publishedAt, String content) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.source = source;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }
    //Getter that can be used in all Classes
    public String getAuthor(){
        try{
            return this.author;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  "";
        }
    }

    public String getTitle(){
        try{
            return this.title;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }

    public String getDescription() {
        try {
            return this.description;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return  "";
        }
    }

    public String getSourceName() {
        try{
            return this.source.getName();
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
            return "";
        }
    }

    public int getAuthorLength(){
        try {
            return this.author.length();
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int getDescriptionLength(){
        try {
            return this.description.length();
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrlToImage() {
        return this.urlToImage;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("\n");

        if (this.getAuthor() != null){
            string.append("Author: ").append(this.getAuthor()).append("\n");
        }
        if (this.getTitle() != null){
            string.append("Title: ").append(this.getTitle()).append("\n");
        }
        if (this.getDescription() != null){
            string.append("Description: ").append(this.getDescription()).append("\n");
        }
        if (this.getSourceName() != null){
            string.append("Source: ").append(this.getSourceName()).append("\n");
        }
        if (this.getUrl() != null){
            string.append("URL: ").append(this.getUrl()).append("\n");
        }
        if (this.getUrlToImage() != null){
            string.append("Image: ").append(this.getUrlToImage()).append("\n");
        }
        if (this.getPublishedAt() != null){
            string.append("Published at: ").append(this.getPublishedAt()).append("\n");
        }
        if (this.getContent() != null){
            string.append("Content: ").append(this.getContent()).append("\n");
        }

        return string.toString();
    }

}
