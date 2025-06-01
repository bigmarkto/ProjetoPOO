package entidades;

public class Dono {
    // Atributos
    String nome;

    /**
     * Construtor da classe Dono.
     *
     * @param nome O nome do dono.
     */
    public Dono(String nome) {
        this.nome = nome;
    }

    // Getters
    /**
     * Retorna o nome do dono.
     *
     * @return O nome do dono.
     */
    public String getNome() {
        return nome;
    }
}
