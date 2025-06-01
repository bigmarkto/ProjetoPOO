package entidades.interfaces;

public interface AtendimentoInterface {

    /**
     * Interface para gerenciar atendimentos de animais.
     * Define os métodos necessários para agendar, cancelar e listar atendimentos,
     * além de buscar atendimentos por ID e inicializar o menu de atendimentos.
     */
    
    public void agendarAtendimento();
    public void cancelarAtendimento();
    public void listarAtendimentos();
    public void buscarAtendimentoPorId();
    public void menuInicializar();
}