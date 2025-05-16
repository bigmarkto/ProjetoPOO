package Entidades.Classes_Animais;

import Entidades.Dono;

public class Gato extends Animal {
    public String nome;
    public int idade;
    public Dono Dono;

    public Gato(String nome, int idade, Dono dono) {
        super(nome, idade, dono);
    }
    
}