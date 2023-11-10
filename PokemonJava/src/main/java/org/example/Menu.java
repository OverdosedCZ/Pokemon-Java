package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Menu extends Pokedex{

    public void vyvolejMenu() throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("\nZvolte prosim operaci: \n-------------------------------");
        System.out.println("Pridat pokemona (1) \nFiltrovany vyber (2) \nVypsat pokedex (3) \nPorovnani pokemonu (4) \nUlozit/nacist pokedex (5) \n-------------------------------");
        switch (input.nextInt()){
            case 1:
               pridejPokemona();
                break;
            case 2:
                vypisFiltry();
                break;
            case 3:
                vypisPokedex();
                break;
            case 4:
                System.out.print("Jakeho pokemona budete porovnavat? (Pikachu): ");
                String pokemon1 = input.next();
                porovnejPokemony(pokemon1);
                break;
            case 5:
                vyvolejFileMenu();
                break;
            default:
                napisError();
                break;
        }
    }

    public void vyvolejFileMenu() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Zvolte prosim operaci: \n------------------------------- \nUlozit pokedex(1) " +
                "\nNacist pokedex (2) \nJit zpatky do menu (3) \n-------------------------------");
        switch(input.nextInt()){
            case 1:
                zeptejNaTypUlozeni();
                break;
            case 2:
                System.out.print("Zadejte jmeno souboru: ");
                nactiZeSouboru(input.next());
                break;
            case 3:
                vyvolejMenu();
                break;
            default:
                napisError();
                break;
        }
    }

    public void zeptejNaTypUlozeni() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Zvolte prosim operaci: \n------------------------------- " +
                "\nVytvorit novy soubor a ulozit (1)" +
                "\nUlozit do jineho souboru (2) \n-------------------------------");
        switch (input.nextInt()){
            case 1:
                System.out.print("Jak chcete aby se jmenoval vas soubor?: ");
                ulozDoTohotoSouboru(input.next());
                break;
            case 2:
                break;
            default:
                napisError();
                break;
        }
    }

    public void napisError(){
        System.out.println("\nNelze zpracovat! (napiste jedno z cisel napsane vedle operaci (1, 2, 3)");
    }
}
