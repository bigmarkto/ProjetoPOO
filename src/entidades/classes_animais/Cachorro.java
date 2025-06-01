package entidades.classes_animais;
import entidades.Animal;
import entidades.Dono;

public class Cachorro extends Animal {

    private String nome;
    private int idade;
    private Dono Dono;

    public Cachorro(String nome, int idade, Dono dono) {
        super(nome, idade, dono);
    }

    /**
     * Retorna o tipo do animal como uma string.
     * 
     * @return A string "Cachorro" indicando o tipo do animal.
     */
    @Override
    public String getTipo() {
        return "Cachorro";
    }
}