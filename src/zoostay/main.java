/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoostay;
import java.util.Scanner;

/**
 *
 * @author 14257017
 */
public class main {

    public static void main(String[] args) {
        // 1. Definition der fairen Preise in Dollar
        final double PREIS_BABY = 10.00;
        final double PREIS_KIND = 45.00;
        final double PREIS_ERWACHSENER = 95.00;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Wie viele Reisende gibt es insgesamt? ");
        int anzahl = scanner.nextInt();

        int[] alterArray = new int[anzahl];

        for (int i = 0; i < anzahl; i++) {
            System.out.print("Bitte gib das Alter der Person " + (i + 1) + " ein: ");
            alterArray[i] = scanner.nextInt();
        }

        scanner.close();

        // 2. Kunde-Objekt erzeugen
        Kunde neuerKunde = new Kunde(alterArray);
        neuerKunde.detailsAnzeigen();

        // 3. Preiskalkulation über die neuen Getter-Methoden
        double kostenBabys = neuerKunde.getAnzahlBabys() * PREIS_BABY;
        double kostenKinder = neuerKunde.getAnzahlKinder() * PREIS_KIND;
        double kostenErwachsene = neuerKunde.getAnzahlErwachsene() * PREIS_ERWACHSENER;
        double gesamtKosten = kostenBabys + kostenKinder + kostenErwachsene;

        // 4. Rechnung ausgeben
        System.out.println("\n=== Preiskalkulation (Zoo-Stay) ===");
        System.out.println("Kosten Babys:      $" + kostenBabys);
        System.out.println("Kosten Kinder:     $" + kostenKinder);
        System.out.println("Kosten Erwachsene: $" + kostenErwachsene);
        System.out.println("---------------------------------");
        System.out.println("Gesamtpreis:       $" + gesamtKosten);
    }
}

