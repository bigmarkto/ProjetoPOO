package entidades.classes_animais;
import entidades.Animal;
import entidades.Dono;

public class Coelho extends Animal{
    
    private String nome;
    private int idade;
    private Dono Dono;

    public Coelho(String nome, int idade, Dono dono) {
        super(nome, idade, dono);
    }
    
/**
 * Retorna o tipo do animal como uma string.
 *
 * @return A string "Coelho" indicando o tipo do animal.
 */
    @Override
    public String getTipo() {
        return "Coelho";
    }
}
