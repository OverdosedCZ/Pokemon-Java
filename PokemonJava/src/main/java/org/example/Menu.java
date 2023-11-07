package org.example;

import java.util.Scanner;

public class Menu extends Pokedex{

    public void vyvolejMenu(){

        Scanner input = new Scanner(System.in);

        System.out.println("Zvolte prosim operaci: \n-------------------------------");
        System.out.println("Pridat pokemona (1) \nFiltrovany vyber (2) \nVypsat pokedex (3) \nPorovnani pokemonu (4) \n-------------------------------");
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
                porovnejPokemony();
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
