package at.ac.fhcampuswien;

public class Article {
    //Attributes
    private final String author;
    private final String title;
    private final String description;
    private final String content;
    private final Source source;
    private final String url;
    private final String urlToImage;
    private final String publishedAt;

    //Constructor for this Class

    private Article(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.description = builder.description;
        this.source = builder.source;
        this.url = builder.url;
        this.urlToImage = builder.urlToImage;
        this.publishedAt = builder.publishedAt;
        this.content = builder.content;
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



    public static class Builder{
        private String author;
        private String title;
        private String description;
        private String content;
        private Source source;
        private String url;
        private String urlToImage;
        private String publishedAt;

        public Builder(){}

        public Builder author(String author){
            this.author = author;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder content(String content){
            this.content = content;
            return this;
        }

        public Builder source(Source source){
            this.source = source;
            return this;
        }

        public Builder url(String url){
            this.url = url;
            return this;
        }

        public Builder urlToImage(String urlToImage){
            this.urlToImage = urlToImage;
            return this;
        }

        public Builder publishedAt(String publishedAt){
            this.publishedAt = publishedAt;
            return this;
        }

        public Article build(){
            return new Article(this);
        }


    }

}
