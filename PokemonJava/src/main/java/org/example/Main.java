package org.example;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Menu menu = new Menu();
        Pokedex pokedex = new Pokedex();

        Scanner input = new Scanner(System.in);
        boolean vypnoutProgram = false;
        menu.vyvolejMenu();

        do {
            System.out.println("Chcete jit zpatky do menu (1) nebo vypnout program? (2)");
            if (input.nextInt() == 1){
                menu.vyvolejMenu();
            } else {
                vypnoutProgram = true;
            }
        } while (vypnoutProgram == true);
    }
}