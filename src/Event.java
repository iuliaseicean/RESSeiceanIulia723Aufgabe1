import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    @JsonProperty("Id")
    private int id;

    @JsonProperty("Charaktername")
    private String charaktername;

    @JsonProperty("Stufe")
    private Stufe stufe; // ENUM în loc de String

    @JsonProperty("Beschreibung")
    private String beschreibung;

    @JsonProperty("Datum")
    private String datum;

    @JsonProperty("Kraftpunkte")
    private double kraftpunkte;

    // Constructor gol necesar pentru deserializare
    public Event() {}

    public Event(int id, String charaktername, Stufe stufe, String beschreibung, String datum, double kraftpunkte) {
        this.id = id;
        this.charaktername = charaktername;
        this.stufe = stufe;
        this.beschreibung = beschreibung;
        this.datum = datum;
        this.kraftpunkte = kraftpunkte;
    }

    // Getters și Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharaktername() {
        return charaktername;
    }

    public void setCharaktername(String charaktername) {
        this.charaktername = charaktername;
    }

    public Stufe getStufe() {
        return stufe;
    }

    public void setStufe(Stufe stufe) {
        this.stufe = stufe;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getKraftpunkte() { return kraftpunkte; }
    public void setKraftpunkte(double kraftpunkte) { this.kraftpunkte = kraftpunkte; }
    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", charaktername='" + charaktername + '\'' +
                ", stufe=" + stufe +
                ", beschreibung='" + beschreibung + '\'' +
                ", datum='" + datum + '\'' +
                ", kraftpunkte=" + kraftpunkte +
                '}';
    }
}
