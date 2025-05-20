package Entidades;

public class Dono {
    String nome;

    /**
     * Construtor da classe Dono.
     *
     * @param nome O nome do dono.
     */
    public Dono(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome do dono.
     *
     * @return O nome do dono.
     */
    public String getNome() {
        return nome;
    }
}
