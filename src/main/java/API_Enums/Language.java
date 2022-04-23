package API_Enums;
// Sprachen und dazu passende abkürzungen von Susi Kloss

public enum Language {
    ARABIC("ar"),
    BULGARIAN("bg"),
    BOSNIAN("bs"),
    CZECH("cs"),
    German("de"),
    GREEK("el"),
    ENGLISH("en"),
    SPANISH("es"),
    FRENCH("fr"),
    HEBREW("he"),
    CROATIAN("hr"),
    HUNGARIAN("hu"),
    INDONESIAN("id"),
    ITALIAN("it"),
    KOREAN("ko"),
    LATVIAN("lv"),
    LITHUANIAN("lt"),
    MALAY("ms"),
    DUTCH("nl"),
    NORWEGIAN("no"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    NORTHERN_SAMI("se"),
    SLOVENIAN("sl"),
    SLOVAK("sk"),
    SWEDISH("sv"),
    THAI("th"),
    TURKISH("tr"),
    UKRAINIAN("ur"),
    CHINESE("zh");

    public final String language;

    Language(String language) {
        this.language = language;
    }
}
