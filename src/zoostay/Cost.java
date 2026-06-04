/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zoostay;

import java.util.Scanner;

/**www
 *
 * @author 14257017
 */
public class Cost {


    private final Scanner scanner = new Scanner(System.in);
    private float totalPrice;

    public void changeTotalPrice(float number) {
        this.totalPrice += number;
    }

    public void chooseContinent() {
        System.out.println("""
                Zu welchem Kontinent wollen Sie reisen?
                1: Eurasien [500$]
                2: Afrika [69$]
                3: Nordamerika [800$]
                4: Lateinamerika [299$]
                5: Australien und Ozeanien [1099$]
                6: tropisches Zentrum [12$]
                7: Meereswelt [90$]
                """);

        System.out.print("Ihre Auswahl: ");
        int choice = scanner.nextInt();

        //hardgecodede Werte, ich kriege ein Bimmel aber reicht aus, f damit float ist
        float price = switch (choice) {
            case 1 ->
                500f;
            case 2 ->
                69f;
            case 3 ->
                800f;
            case 4 ->
                299f;
            case 5 ->
                1099f;
            case 6 ->
                12f;
            case 7 ->
                90f;
            default -> {
                System.out.println("Fehlerhafte Auswahl!");
                yield 0f;
            }
        };

        changeTotalPrice(price);
    }
}


