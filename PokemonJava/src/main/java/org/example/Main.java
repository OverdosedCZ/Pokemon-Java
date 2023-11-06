package org.example;

public class Main {

    public static void main(String[] args) {
        Pokedex kantoRegion = new Pokedex();
        kantoRegion.userInputPrompt();
        kantoRegion.vypisPokedex();
        kantoRegion.vypisElementu("El");
    }
}