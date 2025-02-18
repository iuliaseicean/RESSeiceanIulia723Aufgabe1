import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "src/evenimente.tsv"; // Asigură-te că fișierul este în directorul corect

        List<Event> events = readTsvFile(filePath);
        if (events.isEmpty()) {
            System.out.println("Keine Daten gefunden.");
            return;
        }

        // Afișați opțiuni utilizatorului
        System.out.println("Introduceti kraftpunktul minim: ");
        int minKraftpunkt = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("\nJocuri cu capacitate >= " + minKraftpunkt + ":");
        displayEventesByMinCapacity(events, minKraftpunkt);

        // b) Afișează evenimentele casei Stark sortate după dată
        showEreignisseForStufe(events, Stufe.JONIN);



    }

    // Citirea fișierului TSV
    public static List<Event> readTsvFile(String filePath) {
        List<Event> events = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Sar peste antet
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length < 6) continue; // Evit linii incomplete

                String charaktername = data[1];
                Stufe stufe = Stufe.valueOf(data[2].toUpperCase());
                String beschreibung = data[3];
                String datumString = data[4];
                Double kraftpunkte = Double.parseDouble(data[5]);

                // Convertește șirul de caractere în LocalDate
                LocalDate datum = LocalDate.parse(datumString, formatter);

                // Adaugă obiectul Event în listă
                events.add(new Event(0, charaktername, stufe, beschreibung, datum.toString(), kraftpunkte));
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der TSV-Datei: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Fehler beim Verarbeiten der Daten: " + e.getMessage());
        }
        return events;
    }

    // Metodă pentru a afișa meciurile cu capacitate minimă
    public static void displayEventesByMinCapacity(List<Event> events, int minKraftpunkt) {
        for (Event event : events) {
            if (event.getKraftpunkte() >= minKraftpunkt) {
                System.out.println(event);
            }
        }
    }

    // Afișează evenimentele unei case sortate după dată
    public static void showEreignisseForStufe(List<Event> events, Stufe stufe) {
        List<Event> stufeEvents = events.stream()
                .filter(event -> event.getStufe() == stufe)
                .sorted(Comparator.comparing(Event::getDatum))
                .collect(Collectors.toList());

        System.out.println("Ereignisse des Stufes " + stufe + ":");
        stufeEvents.forEach(System.out::println);
    }



}
