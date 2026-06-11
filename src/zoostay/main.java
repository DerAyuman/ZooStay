package zoostay;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cost kosten = new Cost(scanner);

        // Preise
        final double PREIS_BABY = 10.00;
        final double PREIS_KIND = 45.00;
        final double PREIS_ERWACHSENER = 95.00;

        System.out.println("""
                +======================================+
                |         KOSTEN PRO PERSON            |
                +======================================+
                | 1. Baby (0-1)               10 $     |
                | 2. Kind (2-12)              45 $     |
                | 3. Erwachsen (12+)          95 $     |
                +======================================+
                """);

        System.out.print("Wie viele Reisende gibt es insgesamt? ");
        int anzahl = scanner.nextInt();

        int[] alterArray = new int[anzahl];

        for (int i = 0; i < anzahl; i++) {
            System.out.print("Bitte gib das Alter der Person " + (i + 1) + " ein: ");
            alterArray[i] = scanner.nextInt();
        }

        // Kunde erzeugen
        Kunde neuerKunde = new Kunde(alterArray);
        neuerKunde.detailsAnzeigen();

        // Kosten berechnen
        double kostenBabys = neuerKunde.getAnzahlBabys() * PREIS_BABY;
        double kostenKinder = neuerKunde.getAnzahlKinder() * PREIS_KIND;
        double kostenErwachsene = neuerKunde.getAnzahlErwachsene() * PREIS_ERWACHSENER;

        double gesamtKosten = kostenBabys + kostenKinder + kostenErwachsene;

        System.out.println("\n=== Preiskalkulation (Zoo-Stay) ===");
        System.out.println("Kosten Babys:      $" + kostenBabys);
        System.out.println("Kosten Kinder:     $" + kostenKinder);
        System.out.println("Kosten Erwachsene: $" + kostenErwachsene);
        System.out.println("---------------------------------");
        System.out.println("Zwischensumme:     $" + gesamtKosten);

        // Basispreis an Cost übergeben
        kosten.setTotalPrice(gesamtKosten);

        // Extras
        kosten.chooseContinent();
        kosten.chooseAnreise();

        // Endpreis
        System.out.println("\n=================================");
        System.out.println("Endpreis inkl. Extras: $" + kosten.getTotalPrice());
        System.out.println("=================================");

        scanner.close();
    }
}