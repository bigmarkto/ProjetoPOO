
//Classes
public class GerenciadorProdutos implements ProdutosInterface
{
    //Atributos
    private List<Produto> produtos;

    //Construtores
    public GerenciadorProdutos()
    {
        produtos = new List<Produto>();
    }

    //Metodos
    private void AdicionarProduto(Produto produto)
    {
        produtos.Add(produto);
    }

    private void RemoverProduto(Produto produto)
    {
        produtos.Remove(produto);
    }

    private List<Produto> ObterProdutos()
    {
        return produtos;
    }
}