package Entidades.Gerenciadores;

import Entidades.Interfaces.CompraInterface;
import Entidades.Produto;
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
    
    public void comprarProduto() {
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
    }

}

