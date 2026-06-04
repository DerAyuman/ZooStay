package zoostay;

/**
 *
 *  @author 14257017, 14257064 (Alex und Roi)
 */
public class Kunde {
    private int anzahlReisende;
    private int anzahlBabys;       // 0–1 Jahr
    private int anzahlKinder;      // 2–11 Jahre
    private int anzahlErwachsene;  // ab 12 Jahren

    public Kunde(int[] alterDerReisenden) {
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
                System.out.println("Ungültiges Alter übersprungen: " + alter);
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

    // NEU: Getter-Methoden, um die Werte in der Main-Klasse nutzen zu können
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