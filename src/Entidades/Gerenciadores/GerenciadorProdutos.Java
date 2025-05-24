//Importes
import java.util.ArrayList;
import java.util.Scanner;

import Entidades.Produto;

//Classes
public class GerenciadorProdutos implements ProdutosInterface
{
    //Atributos
    private List<Produto> produtos;
    Scanner sc = new Scanner(System.in);
    this.produtos = new List<Produto>();

    //Construtores
    public GerenciadorProdutos()
    {
        int p;
        do{
        System.out.println("Bem-vindo ao gerenciador de produtos! O que deseja fazer?");
        System.out.println("1 - Adicionar um produto");
        System.out.println("2 - Remover um produto");
        System.out.println("3 - Listar todos os produtos");
        System.out.println("0 - Sair");
        p = sc.nextInt();
        sc.nextLine();

        switch (p) {
            case 1:
                AdicionarProduto();
                break;
            case 2:
                RemoverProduto();
                break;
            case 3:
                ListarProdutos();
                break;
            case 0:
                System.out.println("Saindo do gerenciador de produtos...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        } while (p != 0);
    }

    //Metodos
    private void AdicionarProduto()
    {
        this.produtos.Add(produto);
    }

    private void RemoverProduto()
    {
        this.produtos.Remove(produto);
    }

    private List<Produto> ListarProdutos()
    {
        return produtos;
    }
}