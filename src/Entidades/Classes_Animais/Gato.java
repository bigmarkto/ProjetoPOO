package Entidades.Classes_Animais;
import Entidades.Dono;
import Entidades.Animal;

public class Gato extends Animal {
    private String nome;
    private int idade;
    private Dono Dono;
    private int id;

    public Gato(String nome, int idade, Dono dono) {
        super(nome, idade, dono);
    }
}