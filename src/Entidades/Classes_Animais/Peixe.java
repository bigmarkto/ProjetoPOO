package Entidades.Classes_Animais;

import Entidades.Dono;

public class Peixe {
    public String nome;
    public int idade;
    public Dono Dono;

    public Peixe(String nome, int idade, Dono dono) {
        this.nome = nome;
        this.idade = idade;
        this.Dono = dono;
    }
}
