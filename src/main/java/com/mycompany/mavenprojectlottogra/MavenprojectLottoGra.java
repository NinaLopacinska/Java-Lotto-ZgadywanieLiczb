/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenprojectlottogra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 48514
 */
public class MavenprojectLottoGra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random generator = new Random();

        List<Integer> liczbyUzytkownika = new ArrayList<>();
        List<Integer> liczbyRandom = new ArrayList<>();
        System.out.println("Witaj w Grze!");

        int nrOpcji;
        boolean czyWyjsc = false;
        do {
            System.out.println("1. Gra w lotto");
            System.out.println("2. Gra w zgadywanie liczby");
            System.out.println("3. Wyjdz");
            nrOpcji = scanner.nextInt();

            switch (nrOpcji) {
                case 1:
                    int liczba;
                    int i = 0;
                    boolean wyjscie = false;
                    do {
                        System.out.println("Podaj liczbe z przedziału od 1 do 49:");
                        liczba = scanner.nextInt();

                        // Sprawdzamy czy liczba jest w przedziale 1-49
                        if (liczba > 0 && liczba <= 49) {
                            liczbyUzytkownika.add(liczba);
                            i = i + 1;
                            System.out.println("Liczba dodana");
                        } else {
                            System.out.println("Błąd: liczba musi być z przedziału od 1 do 49");
                        }

                        // Sprawdzamy, czy dodano już 6 liczb
                        if (i == 6) {
                            wyjscie = true;
                        }

                    } while (!wyjscie);

                    while (liczbyRandom.size() < 6) {
                        int liczbaR = generator.nextInt(49) + 1;
                        if (!liczbyRandom.contains(liczbaR)) {  // Dodajemy tylko, jeśli liczba nie jest jeszcze na liście
                            liczbyRandom.add(liczbaR);
                        }
                    }
                    int trafienia = 0;
                    for (int userLiczba : liczbyUzytkownika) {
                        if (liczbyRandom.contains(userLiczba)) {
                            trafienia++;
                        }
                    }
                    System.out.println("Trafiles: " + trafienia);
                    // Wyświetlamy wyniki
                    System.out.println("Twoje liczby: " + liczbyUzytkownika);
                    System.out.println("Losowe liczby: " + liczbyRandom);
                    break;
                case 2:
                    int wylosowana = generator.nextInt(100);
                    System.out.println(wylosowana);
                    boolean wygrana = false;
                    int proby = 1;
                    do {
                        System.out.println("Podaj liczbe od 1 do 100 i sprawdx czy zgadles: ");
                        int liczbaUzytkownika = scanner.nextInt();
                        if (liczbaUzytkownika == wylosowana) {
                            System.out.println("Brawo!");
                            System.out.println("Udalo Ci sie zgadnac za " + proby + " razem.");
                            wygrana = true;

                        } else if (liczbaUzytkownika > wylosowana) {
                            System.out.println("Mniej.");
                            proby++;
                        } else if (liczbaUzytkownika < wylosowana) {
                            System.out.println("Wiecej");
                            proby++;
                        }

                    } while (!wygrana);
                    break;

                case 3:
                    System.out.println("Do zobaczenia");
                    czyWyjsc = true;
                    break;
                default:
                    throw new AssertionError();
            }
        } while (!czyWyjsc);
    }
}
