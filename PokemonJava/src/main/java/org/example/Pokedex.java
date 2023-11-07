package org.example;

import java.util.Scanner;

public class Pokedex extends Menu{

    Scanner input = new Scanner(System.in);

    private Pokemon[] pokemoni;

    private int aktualniPoziceVListu = 0;
    private final int MAX_POKEMONI = 40;

    public Pokedex() {
        this.pokemoni = new Pokemon[MAX_POKEMONI];
    }

    public void pridejPokemona() {
        System.out.print("Kolik pokemonu chcete pridat?: ");
        int pocet = input.nextInt();
        for (int i = 0; i < pocet; i++) {
            System.out.print("------------------------------- \nZadejte jmeno pokemona: ");
            String name = input.next();

            System.out.print("Zadejte element pokemna: ");
            String element = input.next();

            System.out.print("Zadejte HP pokemona: ");
            int hp = input.nextInt();

            System.out.print("Zadejte level pokemona: ");
            int level = input.nextInt();

            pokemoni[aktualniPoziceVListu] = new Pokemon(name, element, hp, level);
            aktualniPoziceVListu++;

            System.out.println("Novy pokemon: " + name + " byl uspesne vytvoren! (Jmeno: " + name +" element: " + element + " HP: " + hp + " level: " + level + ")");
        }
    }

    public void vypisPokedex() {
        for (int i = 0; i < pokemoni.length; i++) {
            if (pokemoni[i] == null) {
                break;
            } else {
                System.out.println(pokemoni[i]);
            }
        }
    }

    public void vypisFiltry() {
        System.out.println("Vyberte typ filtru: \n------------------------------- \nPodle elementu (1) \nPodle HP(2) \nPodle levelu (3) \n-------------------------------");
        switch (input.nextInt()) {
            case 1:
                filtrujElement();
                break;
            case 2:
                filtrujHP();
                break;
            case 3:
                filtrujLevel();
                break;
            default:
                napisError();
                break;
        }
    }

    public void filtrujElement() {
        System.out.print("Jaky element chcete vypsat? (El)");
        String vybranyElement = input.next();
        System.out.println(vybranyElement + " pokemoni:");
        for (int i = 0; i < pokemoni.length; i++) {
            if (vybranyElement.equals(pokemoni[i].getElement())) { // pokud vybranny element "El" je stejny jako element "El" v pokemonu v poli pokemoni
                System.out.println(pokemoni[i].getName());
            }
        }

    }

    public void filtrujHP() {
        System.out.print("Jake HP chcete vypsat? (120)");
        int vybraneHP = input.nextInt();
        System.out.println(vybraneHP + " pokemoni:");
        for (int i = 0; i < pokemoni.length; i++) {
            if (vybraneHP == pokemoni[i].getHp()) {
                System.out.println(pokemoni[i].getHp());
            }
        }
    }

    public void filtrujLevel() {
        System.out.print("Jaky level chcete vypsat? (13)");
        int vybranyLevel = input.nextInt();
        System.out.println(vybranyLevel + " pokemoni:");
        for (int i = 0; i < pokemoni.length; i++) {
            if (vybranyLevel == pokemoni[i].getLevel()) {
                System.out.println(pokemoni[i].getLevel());
            }
        }
    }
}
