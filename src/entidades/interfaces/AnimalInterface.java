package entidades.interfaces;

public interface AnimalInterface  {
    
    /**
    * Métodos a serem implementados pelas classes que implementarem essa interface
    * Cadastrar, alterar, remover, listar e buscar animais
    */
    
    public void cadastrar();
    public void alterar();
    public void remover();
    public void listar();
    public void listar(int tipo);
    public void buscar();
    
}