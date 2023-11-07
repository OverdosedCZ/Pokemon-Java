package org.example;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    Pokedex pokedex = new Pokedex();
    public void vyvolejMenu(){
        System.out.println(" Zvolte prosim operaci: \n-------------------------------");
        System.out.println("Pridat pokemona (1) \nFiltrovany vyber (2) \nVypsat pokedex (3) \n-------------------------------");
        switch (input.nextInt()){
            case 1:
                pokedex.pridejPokemona();
                break;
            case 2:
                pokedex.vypisElementu();
                break;
            case 3:
                pokedex.vypisPokedex();
            default:
                System.out.println("Nelze zpracovat (napiste jedno z cisel napsane vedle operaci (1, 2, 3)");
                break;
        }
    }
}
