package entidades;

public class Produto {
    // Atributos
    private int idProd;
    private String nomeProd;
    private String categoria;
    private double preco;
    private int quantidade;

    // Construtor
    public Produto(int idProd, String nomeProd, String categoria, double preco, int quantidade) {
        this.idProd = idProd;
        this.nomeProd = nomeProd;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    /**
     * Retorna o ID do produto.
     * 
     * @return O ID do produto, que é unico e gerado automaticamente
     *         pelo construtor.
     */
    public int getIdProd() {
        return this.idProd;
    }

    /**
     * Retorna o nome do produto.
     * 
     * @return O nome do produto.
     */
    public String getNomeProd() {
        return this.nomeProd;
    }
    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }


    /**
     * Retorna a categoria do produto.
     * 
     * @return A string que indica a categoria do produto (Alimento, Brinquedo, Higiene, Acessório).
     */
    public String getCategoria() {
        return this.categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna o preço do produto.
     * 
     * @return O preço do produto como um valor do tipo double.
     */
    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Retorna a quantidade do produto.
     * 
     * @return A quantidade do produto como um valor do tipo int.
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     * Define a quantidade do produto.
     * 
     * @param quantidade A nova quantidade do produto.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}