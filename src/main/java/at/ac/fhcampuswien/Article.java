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

    public String getContent() {
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

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("\n");

        if (this.getAuthor() != null){
            string.append("Author: ").append(this.getAuthor()).append("\n");
        }
        if (this.getTitle() != null){
            string.append("Title: ").append(this.getTitle()).append("\n");
        }
        if (this.getContent() != null){
            string.append("Content: ").append(this.getContent()).append("\n");
        }
        if (this.getSource() != null){
            string.append("Source: ").append(this.getSource()).append("\n");
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

        return string.toString();
    }

}
