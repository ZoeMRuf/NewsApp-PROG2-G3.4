package at.ac.fhcampuswien;

public class Article {
    //Attributes
    private String author;
    private String title;

    //Constructor for this Class
    public Article(String author, String title){
        this.author = author;
        this.title = title;
    }

    //Getter that can be used in all Classes
    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    //our own toString, so we don't get the HashCode from the Object-Method(toString)
    @Override
    public String toString(){
        return "Author: " + this.getAuthor() + ", Title: " + this.getTitle();
    }

}
