package entidades.interfaces;

public interface ProdutosInterface {

   /**
    * Interface para gerenciar produtos.
    * Define os métodos necessários para adicionar, remover, listar produtos,
    * e inicializar o menu de produtos.
    */

   public void menuProdutos();
   public void adicionarProduto();
   public void removerProduto();
   public void listarProdutos();
   public void iniciarProdutos();

}