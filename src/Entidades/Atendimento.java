package Entidades;

public class Atendimento {
    private int id;
    private Dono cliente;
    private Animal animal;
    private String dataHora;
    private String servico;

    public Atendimento(int id, Dono cliente, Animal animal, String dataHora, String servico) {
        this.id = id;
        this.cliente = cliente;
        this.animal = animal;
        this.dataHora = dataHora;
        this.servico = servico;
    }

    public int getId() {
        return id;
    }

    public Dono getCliente() {
        return cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String getServico() {
        return servico;
    }
}
