package at.ac.fhcampuswien;

public class Article {
    //Attributes
    private String author;
    private String title;
    private String description;
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

    public Article(String author, String title, String description, String url, String urlToImage, String publishedAt, String content, String source) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.Source = source;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    //Getter that can be used in all Classes
    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription() {
        if (description == null){
            return "Empty";
        }
        return description;
    } // -------> Exeption Handeling

    public int getDescriptionLength(){
        if (description == null){
            return 0;
        }
        return description.length();
    }  // -------> Exeption Handeling

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

    public String getContent() {
        return content;
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
