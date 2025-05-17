package Entidades.Classes_Animais;

import Entidades.Dono;

import Entidades.Animal;

public class Peixe extends Animal {
    public String nome;
    public int idade;
    public Dono Dono;

    public Peixe(String nome, int idade, Dono dono) {
        super(nome, idade, dono);
    }
}
