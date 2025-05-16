package Entidades.Classes_Animais;

import Entidades.Dono;

public class Passaro {
    public String nome;
    public int idade;
    public Dono Dono;

    public Passaro(String nome, int idade, Dono dono) {
        this.nome = nome;
        this.idade = idade;
        this.Dono = dono;
    }
}
