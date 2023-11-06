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
        pokemoni[aktualniPoziceVListu] = userInputPokemon();
        aktualniPoziceVListu++;
    }

    public Pokemon userInputPokemon(){
        System.out.print("Zadejte jmeno pokemona: ");
        String name = input.next();

        System.out.print("Zadejte element pokemna: ");
        String element = input.next();

        System.out.print("Zadejte HP pokemona: ");
        int hp = input.nextInt();

        System.out.print("Zadejte level pokemona: ");
        int level = input.nextInt();

        return new Pokemon(name, element, hp, level);
    }

    public void userInputPrompt(){
        System.out.print("Kolik pokemonu chcete pridat?: ");
        int pocet = input.nextInt();
        for (int i = 0; i < pocet; i++) {
            pridejPokemona();
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

    public void vypisElementu(String vybranyElement){
        for (int i = 0; i < pokemoni.length; i++) {
            if (vybranyElement.equals(pokemoni[i].getElement())){ // pokud vybranny element "El" je stejny jako element "El" v pokemonu v poli pokemoni
                System.out.println(pokemoni[i].getName() + " ma stejny element! (" + vybranyElement + ")");
            }
        }

    }

}
