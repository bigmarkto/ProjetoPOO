package entidades;

public class Atendimento {
    // Atributos    
    private int id;
    private Dono cliente;
    private Animal animal;
    private String dataHora;
    private String servico;

    // Construtor
    public Atendimento(int id, Dono cliente, Animal animal, String dataHora, String servico) {
        this.id = id;
        this.cliente = cliente;
        this.animal = animal;
        this.dataHora = dataHora;
        this.servico = servico;
    }

    // Getters e Setters

    /**
     * Retorna o ID do atendimento.
     * 
     * @return O ID único do atendimento.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o dono que solicitou o atendimento.
     * 
     * @return O dono que solicitou o atendimento.
     */
    public Dono getCliente() {
        return cliente;
    }

    /**
     * Retorna o animal que será atendido.
     * 
     * @return O animal que será atendido.
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * Retorna a data e hora do atendimento.
     * 
     * @return A data e hora do atendimento no formato "dd/MM/yyyy HH:mm".
     */
    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Retorna o serviço que será prestado no atendimento.
     * 
     * @return O serviço que será prestado no atendimento.
     */
    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
}
