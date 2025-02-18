import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Stufe {
    GENIN("Genin"),
    CHUNIN(" Chunin"),
    JONIN("Jonin"),
    KAGE("Kage"),;
    private final String name;

    Stufe(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static Stufe fromString(String value) {
        for (Stufe stufe : Stufe.values()) {
            if (stufe.name.equalsIgnoreCase(value)) {
                return stufe;
            }
        }
        throw new IllegalArgumentException("Unknown stufe: " + value);
    }
}
