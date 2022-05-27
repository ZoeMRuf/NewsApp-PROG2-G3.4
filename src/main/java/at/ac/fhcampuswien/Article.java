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
        return this.author;
    }

    public int getAuthorLength(){
        if (author == null){
            return 0;
        }
        return author.length();
    }  // -------> Exeption Handeling

    public String getTitle(){
        return this.title;
    }

    public String getDescription() {
        if (description == null){
            return "Empty";
        }
        return description;
    } // -------> Exeption Handeling

    public int getDescriptionLength() throws NewAPIException{
        try {
            return description.length();
        }
        catch (Exception e){
            throw new NewAPIException("Hallo");

            /*
            e.getMessage();
            System.out.println("Description of the Article is null");
            return 0;

             */
        }
    }  // -------> Exeption Handeling

    public Object getSourceId() {
        return source.getId();
    }

    public String getSourceName() {
        return source.getName();
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
