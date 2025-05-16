package Entidades.Classes_Animais;

import Entidades.Dono;

public class Passaro extends Animal {
    public String nome;
    public int idade;
    public Dono Dono;

    public Passaro(String nome, int idade, Dono dono) {
        super(nome, idade, dono);
    }
}
