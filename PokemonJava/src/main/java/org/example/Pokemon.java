package org.example;

public class Pokemon {
    private String name;
    private String element;
    private int hp;
    private int level;


    public Pokemon(String name, String element, int hp, int level) {
        this.name = name;
        this.element = element;
        this.hp = hp;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "name='" + name + '\'' + ", element='" + element + '\'' + ", hp=" + hp + ", level=" + level + '}';
    }
}
