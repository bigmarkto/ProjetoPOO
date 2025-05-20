package Entidades.Classes_Animais;
import Entidades.Dono;
import Entidades.Animal;

public class Coelho extends Animal{
    
    private String nome;
    private int idade;
    private Dono Dono;

    public Coelho(String nome, int idade, Dono dono) {
        super(nome, idade, dono);
    }

    @Override
    public String getTipo() {
        return "Coelho";
    }
}
