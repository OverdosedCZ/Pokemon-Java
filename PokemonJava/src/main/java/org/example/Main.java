package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();

        Scanner input = new Scanner(System.in);
        boolean vypnoutProgram = false;
        menu.vyvolejMenu();

        do {
            System.out.println("\nChcete jit zpatky do menu (1) nebo 5vypnout program? (2)");
            if (input.nextInt() == 1){
                menu.vyvolejMenu();
            } else {
                vypnoutProgram = true;
            }
        } while (vypnoutProgram == false);
    }
}