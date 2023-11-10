package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pokedex implements Serializable {

    Scanner input = new Scanner(System.in);

    protected Pokemon[] pokemoni;

    private int aktualniPoziceVListu = 0;
    private final int MAX_POKEMONI = 40;

    public Pokedex() {
        this.pokemoni = new Pokemon[MAX_POKEMONI];
    }

    public void pridejPokemona() {
            pokemoni[aktualniPoziceVListu] = vytvorPokemona();
            aktualniPoziceVListu++;
    }

    public Pokemon vytvorPokemona(){
        System.out.print("------------------------------- \nZadejte jmeno pokemona: ");
        String name = input.next();

        System.out.print("Zadejte element pokemna: ");
        String element = input.next();

        System.out.print("Zadejte HP pokemona: ");
        int hp = input.nextInt();

        System.out.print("Zadejte level pokemona: ");
        int level = input.nextInt();

        System.out.println("\nNovy pokemon: '" + name + "' byl uspesne vytvoren! (Jmeno: " + name +" element: " + element + " HP: " + hp + " level: " + level + ")");

        return new Pokemon(name, element, hp, level);
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
                break;
        }
    }

    public void filtrujElement() {
        System.out.print("Jaky element chcete vypsat? (El): ");
        String vybranyElement = input.next();
        System.out.println(vybranyElement + " pokemoni:");
        for (int i = 0; i < pokemoni.length; i++) {
            if (vybranyElement.equals(pokemoni[i].getElement())) { // pokud vybranny element "El" je stejny jako element "El" v pokemonu v poli pokemoni
                System.out.println(pokemoni[i].getName());
            }
        }

    }

    public void filtrujHP() {
        System.out.print("Jake HP chcete vypsat? (120): ");
        int vybraneHP = input.nextInt();
        System.out.println(vybraneHP + " pokemoni:");
        for (int i = 0; i < pokemoni.length; i++) {
            if (vybraneHP == pokemoni[i].getHp()) {
                System.out.println(pokemoni[i].getHp());
            }
        }
    }

    public void filtrujLevel() {
        System.out.print("Jaky level chcete vypsat? (13): +");
        int vybranyLevel = input.nextInt();
        System.out.println(vybranyLevel + " pokemoni:");
        for (int i = 0; i < pokemoni.length; i++) {
            if (vybranyLevel == pokemoni[i].getLevel()) {
                System.out.println(pokemoni[i].getLevel());
            }
        }
    }

    public void porovnejPokemony(String jmenoPokemona1){
        System.out.print("S jakym pokemonem ho budete porovnavat?: (Charizzard) ");
        String jmenoPokemona2 = input.next();

        var pokemon1stream =  Arrays.stream(pokemoni).filter(x -> x.getName().equals(jmenoPokemona1)).findFirst();
        var pokemon2stream =  Arrays.stream(pokemoni).filter(x -> x.getName().equals(jmenoPokemona2)).findFirst();
        if (pokemon1stream.isEmpty() || pokemon2stream.isEmpty()){
            System.out.println("Neni co porovnat");
            return;
        }
        var pokemon1 = pokemon1stream.get();
        var pokemon2 = pokemon2stream.get();

        System.out.println("\nSily pokemonu: " + "\n" + jmenoPokemona1 + " se silou " + vypocitejSilu(pokemon1) + "\n" + jmenoPokemona2 + " se silou " + vypocitejSilu(pokemon2));

        if (vypocitejSilu(pokemon1) > vypocitejSilu(pokemon2)){
            System.out.println("Vyhraje: " + jmenoPokemona1);
        } else {
            System.out.println("Vyhraje: " + jmenoPokemona2);
        }
    }

    public double vypocitejSilu(Pokemon pokemon){
        return Math.sqrt(pokemon.getHp()*pokemon.getLevel());
    }

    public void ulozDoTohotoSouboru(String jmenoSouboru) {
        try {
            FileWriter fw = new FileWriter(jmenoSouboru + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println(this.pokemoni.length);
            for (int i = 0; i < this.pokemoni.length; i++) {
                if (this.pokemoni[i] == null){
                    break;
                }
                bw.write(this.pokemoni[i].toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void nactiZeSouboru(String jmenoSouboru) {
        try {
            FileReader fr = new FileReader(jmenoSouboru + ".txt");
            BufferedReader br = new BufferedReader(fr);

            List<String> lines = new ArrayList<String>();
            String line = "";

            while ((line = br.readLine()) != null){
                lines.add(line);
            }

            br.close();


            for (int i = 0; i < lines.size(); i++) {
                String linesSplitted[] = lines.get(i).split(",");
                Pokemon temp = new Pokemon(linesSplitted[0].split("=")[1], linesSplitted[1].split("=")[1],
                        Integer.parseInt(linesSplitted[2].split("=")[1]) , Integer.parseInt(linesSplitted[3].split("=")[1]));
                this.pokemoni[i] = temp;
                aktualniPoziceVListu++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "pokemoni=" + Arrays.toString(pokemoni) +
                '}';
    }
}


