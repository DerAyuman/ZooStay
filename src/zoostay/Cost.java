package zoostay;

import java.util.Scanner;

public class Cost {

    private final Scanner scanner;
    private double totalPrice;
    
    // NEU: Variablen, um die getroffene Auswahl für den Kassenzettel zu speichern
    private String gewaehltesResort = "Keines";
    private boolean parkplatzGebucht = false;

    public Cost(Scanner scanner) {
        this.scanner = scanner;
        this.totalPrice = 0;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void changeTotalPrice(double amount) {
        totalPrice += amount;
    }

    public void chooseContinent() {

        System.out.println("""
                +======================================+

                |         ZOO STAY TICKETS             |
                +======================================+

                | 1. Eurasien                  500 $   |
                | 2. Afrika                     69 $   |
                | 3. Nordamerika               800 $   |
                | 4. Lateinamerika             299 $   |
                | 5. Australien/Ozeanien      1099 $  |
                | 6. Tropisches Zentrum         12 $   |
                | 7. Meereswelt                 90 $   |
                +======================================+
                """);

        System.out.print("Ihre Resortwahl (Zahl): ");
        int choice = scanner.nextInt();

        double price = switch (choice) {
            case 1 -> { this.gewaehltesResort = "Eurasien"; yield 500; }
            case 2 -> { this.gewaehltesResort = "Afrika"; yield 69; }
            case 3 -> { this.gewaehltesResort = "Nordamerika"; yield 800; }
            case 4 -> { this.gewaehltesResort = "Lateinamerika"; yield 299; }
            case 5 -> { this.gewaehltesResort = "Australien/Ozeanien"; yield 1099; }
            case 6 -> { this.gewaehltesResort = "Tropisches Zentrum"; yield 12; }
            case 7 -> { this.gewaehltesResort = "Meereswelt"; yield 90; }
            default -> {
                System.out.println("Fehlerhafte Auswahl!");
                this.gewaehltesResort = "Ungültige Auswahl";
                yield 0;
            }
        };

        changeTotalPrice(price);
        System.out.println("Resort hinzugefügt: $" + price);
    }

    public void chooseAnreise() {

        System.out.println("\nParkplatz buchen?");
        System.out.println("[1] Ja (+25$)");
        System.out.println("[2] Nein");

        int choice = scanner.nextInt();

        if (choice == 1) {
            changeTotalPrice(25);
            this.parkplatzGebucht = true; // NEU
            System.out.println("Parkplatz erfolgreich gebucht.");
        } else {
            this.parkplatzGebucht = false; // NEU
            System.out.println("Kein Parkplatz gebucht.");
        }
    }

    // NEU: Getter, um die Namen der Optionen auf dem Kassenzettel auszugeben
    public String getGewaehltesResort() {
        return gewaehltesResort;
    }

    public boolean isParkplatzGebucht() {
        return parkplatzGebucht;
    }
}
