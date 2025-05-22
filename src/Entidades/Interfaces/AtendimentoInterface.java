package Entidades.Interfaces;

public interface AtendimentoInterface {
    public void agendarAtendimento();
    public void cancelarAtendimento();
    public void listarAtendimentos();
    public void buscarAtendimentoPorId(int id);
    public void menuInicializar();
}