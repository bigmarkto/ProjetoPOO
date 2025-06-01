package entidades.gerenciadores;

import entidades.Produto;
import entidades.interfaces.CompraInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorCompra implements CompraInterface
{

    //Atributos
    Scanner sc = new Scanner(System.in);
    private static List<Produto> listarProdutos = new ArrayList<>();
    GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();

    //Metodos
    
    
    /**
     * Exibe o menu de compras de produtos ao usuário.
     *
     * O menu oferece as opções de comprar um produto e sair. O usuário pode 
     * escolher uma opção digitando o número correspondente.
     *
     * Se a opção digitada for inválida, o sistema exibe uma mensagem de erro e 
     * volta a exibir o menu. Caso contrário, o sistema executa a opção escolhida 
     * e volta a exibir o menu.
     *
     * O loop só é interrompido quando o usuário escolhe a opção de sair.
     */
    public void menuCompras() {
        int op;
        do {
        System.out.println("---=== MENU DE COMPRAS DE PRODUTOS ===---");
        System.out.println("1 - Comprar produto");
        System.out.println("0 - Sair");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                comprarProduto();
                break;
            case 0:
                System.out.println("Saindo do gerenciador de compras...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        } while (op != 0);
    }
    
    
    /**
     * Compra um produto existente.
     *
     * Exibe um menu para selecionar o ID do produto a ser comprado. Após a
     * escolha, pergunta a quantidade de produtos que deseja comprar.
     *
     * Se a quantidade for maior do que a quantidade em estoque, exibe uma
     * mensagem de erro. Caso contrário, subtrai a quantidade comprada do
     * estoque e exibe uma mensagem de sucesso.
     *
     * Após a compra, pergunta ao usuario se deseja comprar outro produto.
     * Se a resposta for sim, o loop se repete. Caso contrário, o loop é
     * interrompido e o usuario volta ao menu principal.
     */
    public void comprarProduto() {
        int op = 1;
        do {
        GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();
        gerenciadorProdutos.listarProdutos(); // Lista todos os produtos disponíveis
        System.out.println("Digite o ID do produto que deseja comprar:");
        int id = sc.nextInt();
        sc.nextLine();
        Produto produto = gerenciadorProdutos.getProdutoById(id); 
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        System.out.println("Digite a quantidade que deseja comprar:");
        int quantity = sc.nextInt();
        sc.nextLine();
        if (produto.getQuantidade() >= quantity) {
            produto.setQuantidade(produto.getQuantidade() - quantity);
            System.out.println("Compra realizada com sucesso. Você comprou " + quantity + " unidades de " + produto.getNomeProd());
        } else {
            System.out.println("Estoque insuficiente. Quantidade disponível: " + produto.getQuantidade());
        }

            System.out.println("Deseja comprar outro produto? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
            sc.nextLine();
        } while (op != 0);
    }

}

