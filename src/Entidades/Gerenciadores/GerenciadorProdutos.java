package Entidades.Gerenciadores;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import Entidades.Produto;
import Entidades.Interfaces.ProdutosInterface;

//Classes
public class GerenciadorProdutos implements ProdutosInterface
{
    //Atributos
    Scanner sc = new Scanner(System.in);
    private static List<Produto> produtos = new ArrayList<>();

    //Metodos

    public void menuProdutos(){
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
                adicionarProduto();
                break;
            case 2:
                removerProduto();
                break;
            case 3:
                listarProdutos();
                break;
            case 0:
                System.out.println("Saindo do gerenciador de produtos...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        } while (p != 0);
    }
    public void adicionarProduto()
    {
        
    }

    public void removerProduto()
    {
        
        //Verifica se a lista de produtos está vazia
        if (produtos.isEmpty()) {
            //Se estiver vazia, exibe uma mensagem e retorna
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        //Exibe os produtos cadastrados ao usuário para que ele escolha qual deseja remover
        System.out.println("Digite o ID do produto que deseja remover: ");
        int id = sc.nextInt();
        sc.nextLine();

        listarProdutos();
        
        // Busca o produto pelo ID
    Produto produtoParaCancelar = null;
        for ( Produto produto : produtos) {
            if (produto.getIdProd() == id) {
            produtoParaCancelar =produto;
                break;
            }
        }

        // Cancela oproduto se encontrado
        if (produtoParaCancelar != null) {
            produtos.remove(produtoParaCancelar);
            System.out.println("produto cancelado com sucesso!");
        } else {
            System.out.println("produto não encontrado.");
        }
    }

    public void listarProdutos()
    {
        
        if (produtos.size() == 0)
        {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        //Exibe os produtos cadastrados ao usuário
        System.out.println("---=== LISTA DE PRODUTOS ===---");
        for (Produto produto : produtos)
        {
           System.out.printf("ID: %d | Nome: %s | Preço: %d | Quantidade: %s ",
                produto.getIdProd(),
                produto.getNomeProd(),
                produto.getPreco(),
                produto.getQuantidade());
        }
        System.out.println("---=== FIM DA LISTA ===---");
        
        
        
    }
}