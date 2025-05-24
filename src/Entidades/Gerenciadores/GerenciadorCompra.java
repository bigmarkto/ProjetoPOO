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
        System.out.println("Escolha o produto que deseja comprar:");
        int produtoEscolhido = sc.nextInt();
        sc.nextLine();
        
        GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();
        gerenciadorProdutos.menuProdutos();
    }

}

