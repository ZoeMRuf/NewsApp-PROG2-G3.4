package API_Enums;

public enum Language {
    ARABIC("ar"),
    BULGARIAN("bg"),
    BOSNIAN("bs", language),
    CZECH("cs", language),
    German("de", language),
    GREEK("el", language),
    ENGLISH("en", language),
    SPANISH("es", language),
    FRENCH("fr", language),
    HEBREW("he", language),
    CROATIAN("hr", language),
    HUNGARIAN("hu", language),
    INDONESIAN("id", language),
    ITALIAN("it", language),
    KOREAN("ko", language),
    LATVIAN("lv", language),
    LITHUANIAN("lt", language),
    MALAY("ms", language),
    DUTCH("nl", language),
    NORWEGIAN("no", language),
    POLISH("pl", language),
    PORTUGUESE("pt", language),
    ROMANIAN("ro", language),
    RUSSIAN("ru", language),
    NORTHERN_SAMI("se", language),
    SLOVENIAN("sl", language),
    SLOVAK("sk", language),
    SWEDISH("sv", language),
    THAI("th", language),
    TURKISH("tr", language),
    UKRAINIAN("ur", language),
    CHINESE("zh", language);

    public final String language;

    Language(String language) {
        this.language = language;
    }
}
