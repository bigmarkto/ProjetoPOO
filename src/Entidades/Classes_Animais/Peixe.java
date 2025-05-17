package Entidades.Classes_Animais;
import Entidades.Dono;
import Entidades.Animal;

public class Peixe extends Animal {
    private String nome;
    private int idade;
    private Dono Dono;

    public Peixe(String nome, int idade, Dono dono) {
        super(nome, idade, dono);
    }
}
