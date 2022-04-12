package at.ac.fhcampuswien;

public class Article {
    //Attributes
    private String author;
    private String title;
    private String content;
    private String Source;
    private String url;
    private String urlToImage;
    private String publishedAt;

    //Constructor for this Class
    public Article(String author, String title){
        this.author = author;
        this.title = title;
    }

    public Article(String author, String title, String content, String source, String url, String urlToImage, String publishedAt) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.Source = source;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    //Getter that can be used in all Classes
    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContant() {
        return content;
    }

    public String getSource() {
        return Source;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    //our own toString, so we don't get the HashCode from the Object-Method(toString)
    @Override
    public String toString(){
        return "\n" + "Author: " + this.getAuthor() + ", Title: " + this.getTitle();
    }

}
