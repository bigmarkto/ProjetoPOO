package Entidades.Classes_Animais;
import Entidades.Dono;
import Entidades.Animal;

public class Passaro extends Animal {
    private String nome;
    private int idade;
    private Dono Dono;

    public Passaro(String nome, int idade, Dono dono) {
        super(nome, idade, dono);
    }

    @Override
    public String getTipo() {
        return "Passaro";
    }
}
