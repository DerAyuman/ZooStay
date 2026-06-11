package zoostay;

import java.util.UUID;

/**
 *
 *  @author 14257017, 14257064 (Alex und Roi)
 */
public class Kunde {
    private String auftragsNummer; // NEU: Eindeutige ID für den Eintrittscode
    private int anzahlReisende;
    private int anzahlBabys;       // 0–1 Jahr
    private int anzahlKinder;      // 2–11 Jahre
    private int anzahlErwachsene;  // ab 12 Jahren

    public Kunde(int[] alterDerReisenden) {
        // NEU: Erzeugt eine zufällige, eindeutige 8-stellige ID aus einer UUID (z.B. ZOO-A1B2C3D4)
        this.auftragsNummer = "ZOO-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        
        this.anzahlReisende = alterDerReisenden.length;
        this.anzahlBabys = 0;
        this.anzahlKinder = 0;
        this.anzahlErwachsene = 0;

        for (int alter : alterDerReisenden) {
            if (alter >= 0 && alter <= 1) {
                this.anzahlBabys++;
            } else if (alter >= 2 && alter <= 11) {
                this.anzahlKinder++;
            } else if (alter >= 12) {
                this.anzahlErwachsene++;
            } else {
                System.out.println("Fehlerhaftes Alter übersprungen: " + alter);
                this.anzahlReisende--; 
            }
        }
    } 

    public void detailsAnzeigen() {
        System.out.println("\n=== Aufteilung der Reisegruppe ===");
        System.out.println("Gesamtzahl gültige Reisende: " + anzahlReisende);
        System.out.println("- Babys/Kleinkinder (0-1 J.): " + anzahlBabys);
        System.out.println("- Kinder (2-11 J.): " + anzahlKinder);
        System.out.println("- Erwachsene (ab 12 J.): " + anzahlErwachsene);
    }

    /**
     * NEU: Gibt einen formatierten Kassenzettel auf der Konsole aus.
     */
    public void kassenzettelDrucken(double gesamtPreis, String resort, boolean parkplatz) {
        System.out.println("\n=========================================");
        System.out.println("             ZOOSTAY BELEG               ");
        System.out.println("=========================================");
        System.out.println(" Auftrags-ID:     " + this.auftragsNummer);
        System.out.println("-----------------------------------------");
        System.out.println(" Gebuchte Personen-Tickets:");
        if (anzahlErwachsene > 0) System.out.printf(" - %d x Erwachsene\n", anzahlErwachsene);
        if (anzahlKinder > 0)     System.out.printf(" - %d x Kinder\n", anzahlKinder);
        if (anzahlBabys > 0)      System.out.printf(" - %d x Babys\n", anzahlBabys);
        
        System.out.println(" Gebuchte Extras:");
        System.out.println(" - Resort: " + resort);
        if (parkplatz) {
            System.out.println(" - Option: Inklusive Parkplatz");
        }
        
        System.out.println("-----------------------------------------");
        System.out.printf(" ENDPREIS GESAMT:  $%.2f\n", gesamtPreis);
        System.out.println("=========================================");
        System.out.println("    EINLASS-STRICHCODE (ZUM VORZEIGEN):  ");
        System.out.println("    " + generatePseudoBarcode());
        System.out.println("    " + this.auftragsNummer);
        System.out.println("=========================================");
    }

    /**
     * NEU: Erzeugt eine visuelle Strichcode-Simulation für die Textkonsole.
     */
    private String generatePseudoBarcode() {
        StringBuilder barcode = new StringBuilder("||");
        for (char c : auftragsNummer.toCharArray()) {
            if (c % 2 == 0) {
                barcode.append("|||");
            } else {
                barcode.append("| |");
            }
        }
        barcode.append("||");
        return barcode.toString();
    }

    // Getter für die Auftragsnummer (wichtig für spätere Einlasskontrollen)
    public String getAuftragsNummer() {
        return this.auftragsNummer;
    }

    public int getAnzahlBabys() {
        return this.anzahlBabys;
    }

    public int getAnzahlKinder() {
        return this.anzahlKinder;
    }

    public int getAnzahlErwachsene() {
        return this.anzahlErwachsene;
    }
}
