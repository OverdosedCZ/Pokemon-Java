package org.example;

import java.util.Scanner;

public class Pokedex {

    Scanner input = new Scanner(System.in);
    private Pokemon[] pokemoni;
    private int aktualniPoziceVListu = 0;
    private final int MAX_POKEMONI = 40;

    public Pokedex() {
        this.pokemoni = new Pokemon[MAX_POKEMONI];
    }

    public void pridejPokemona(){
        System.out.print("Kolik pokemonu chcete pridat?: ");
        int pocet = input.nextInt();
        for (int i = 0; i < pocet; i++) {
            System.out.print("Zadejte jmeno pokemona: ");
            String name = input.next();

            System.out.print("Zadejte element pokemna: ");
            String element = input.next();

            System.out.print("Zadejte HP pokemona: ");
            int hp = input.nextInt();

            System.out.print("Zadejte level pokemona: ");
            int level = input.nextInt();

            pokemoni[aktualniPoziceVListu] = new Pokemon(name, element, hp, level);
            aktualniPoziceVListu++;
        }
    }

    public void vypisPokedex(){
        for (int i = 0; i < pokemoni.length; i++) {
            if (pokemoni[i] == null){
                break;
            } else {
                System.out.println(pokemoni[i]);
            }
        }
    }

    public void vypisElementu(){
        System.out.print("Jaky element si prejete vypsat? (El)");
        String vybranyElement = input.next();
        System.out.println(vybranyElement + " pokemoni:");
        for (int i = 0; i < pokemoni.length; i++) {
            if (vybranyElement.equals(pokemoni[i].getElement())){ // pokud vybranny element "El" je stejny jako element "El" v pokemonu v poli pokemoni
                System.out.println(pokemoni[i].getName());
            }
        }

    }

}
