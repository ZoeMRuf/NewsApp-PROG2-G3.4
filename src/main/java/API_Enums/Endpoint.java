package API_Enums;

public enum Endpoint {
    TOPHEADLINE("top-headlines"),
    EVERYTHING("everything");

    public final String endpoint;

    Endpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
