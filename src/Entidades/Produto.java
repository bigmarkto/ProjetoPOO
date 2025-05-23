package Entidades;

public class Produto {
    private int idProd;
    private String nomeProd;
    private double preco;
    private int quantidade;

    public Produto(int idProd, String nomeProd, double preco, int quantidade) {
        this.idProd = idProd;
        this.nomeProd = nomeProd;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getIdProd() {
        return this.idProd;
    }

    public String getNomeProd() {
        return this.nomeProd;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}