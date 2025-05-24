package Entidades.Gerenciadores;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Entidades.Produto;
import Entidades.Gerenciadores.GerenciadorProdutos;
import Entidades.Interfaces.CompraInterface;

public class GerenciadorCompra implements CompraInterface
{

    //Atributos
    Scanner sc = new Scanner(System.in);
    private static List<Produto> listaCompras = new ArrayList<>();
    private static List<Produto> listarProdutos = new ArrayList<>();

    //Metodos
    
    public void menuCompras() {
        int op;
        do {
        System.out.println("---=== MENU DE COMPRAS DE PRODUTOS ===---");
        System.out.println("1 - Comprar produto");
        System.out.println("2 - Cancelar compra");
        System.out.println("3 - Visualizar compras");
        System.out.println("4 - Visualizar produtos");
        System.out.println("0 - Sair");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                comprarProduto();
                break;
            case 2:
                cancelarCompra();
                break;
            case 3:
                visualizarCompras();
                break;
            case 4:
                visualizarProdutos();
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

    public void iniciarCompras() {

        int idProd;
        String[] nomesProd = { "Ração Premium", "Brinquedo Bola", "Coleira Ajustável", "Cama Macia", "Areia Higiênica", "Aquário Pequeno", "Comedouro Inox" };
        String[] categorias = { "Alimentação", "Brinquedos", "Acessórios", "Conforto", "Higiene", "Habitat", "Alimentação" };
        double[] precos = { 49.90, 19.90, 29.90, 89.90, 24.90, 120.00, 15.00 };
        
        Random random = new Random();

        // Adiciona 7 produtos diferentes
        for (int i = 0; i < 7; i++) {
            Produto produto = new Produto(
                idProd = i + 1,
                nomesProd[i],
                categorias[i],
                precos[i],
                random.nextInt(20) + 1 // quantidade em estoque aleatória entre 1 e 20
            );
            listarProdutos.add(produto);
        }
    }

    public void visualizarCompras() {
        System.out.println("Lista de compras:");
        for (Produto produto : listaCompras) {
            System.out.println("ID: " + produto.getIdProd() + ", Nome: " + produto.getNomeProd() + ", Categoria: " + produto.getCategoria() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
        }
    }

    @Override
public void visualizarProdutos() {
    System.out.println("Lista de produtos disponíveis:");
    for (Produto produto : listarProdutos) {
        System.out.println("ID: " + produto.getIdProd() + ", Nome: " + produto.getNomeProd() + ", Categoria: " + produto.getCategoria() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
    }
}

    public void cancelarCompra() {
        System.out.println("Digite o ID do produto que deseja cancelar a compra:");
        int idProduto = sc.nextInt();
        sc.nextLine();
        
        for (Produto produto : listaCompras) {
            if (produto.getIdProd() == idProduto) {
                listaCompras.remove(produto);
                System.out.println("Compra cancelada com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado na lista de compras.");
    }

    
}
