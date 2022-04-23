package API_Enums;

public enum Sortby {
    RELEVANCY("relevancy"),
    POPULARITY("popularity"),
    PUBLISHED_AT("publishedAt");

    public final String sortby;

    Sortby(String sortby) {
        this.sortby = sortby;
    }
}





