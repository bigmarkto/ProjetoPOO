package Entidades.Gerenciadores;

import Entidades.Interfaces.ProdutosInterface;
import Entidades.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                menuListagem();        
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
        int op = 1;
        do {

        String nome;
        String categoria;
        Double preco;
        Integer quantidade;

        System.out.println("Digite o nome do produto: ");
        nome = sc.nextLine();

        System.out.println("Digite a categoria do produto: ");
        categoria = sc.nextLine();
        while (!categoria.equalsIgnoreCase("Alimento") && !categoria.equalsIgnoreCase("Brinquedo") &&
               !categoria.equalsIgnoreCase("Higiene") && !categoria.equalsIgnoreCase("Acessório")) {
            System.out.println("Categoria inválida. Digite novamente (Alimento, Brinquedo, Higiene, Acessório): ");
            categoria = sc.nextLine();
        }
        System.out.println("Digite o preco do produto: ");
        preco = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite a quantidade do produto: ");
        quantidade = sc.nextInt();
        sc.nextLine();

        int id = produtos.size() + 1;

        Produto produto = new Produto(id,nome,categoria,preco,quantidade);
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");

        System.out.println("Deseja cadastrar outro produto? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
            sc.nextLine();
        } while (op != 0);
    }

    protected Produto getProdutoById(int id) {
        for (Produto idProduto : produtos) {
            if (idProduto.getIdProd() == id) {
                return idProduto;
            }
        }
        return null;
    }

    public void removerProduto()
    {

        int op = 1;
        do {
        listarProdutos();
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
        System.out.println("Deseja remover outro produto? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
            sc.nextLine();
        } while (op != 0);
    }

    public void menuListagem(){
        int op;
        do{
        System.out.println("Escolha uma opção de listagem:");
        System.out.println("1 - Listar todos os produtos");
        System.out.println("2 - Listar produtos por categoria");
        System.out.println("0 - Voltar");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                listarProdutos();
                break;
            case 2:
                System.out.println("Escolha uma categoria:");
                System.out.println("1 - Alimento");
                System.out.println("2 - Brinquedo");
                System.out.println("3 - Higiene");
                System.out.println("4 - Acessório");
                int opCategoria = sc.nextInt();
                sc.nextLine();
                listarPorCategoria(opCategoria);
                break;
            case 0:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        } while (op != 0);
    }

    public void listarProdutos()
    {
        //Verifica se a lista de produtos está vazia
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }



        //Exibe os produtos cadastrados ao usuário
        System.out.println("---=== LISTA DE PRODUTOS ===---");
        for (Produto produto : produtos)
        {
           System.out.printf("ID: %d | Nome: %s | Categoria: %s | Preço: %.2f | Quantidade: %s \n",
                produto.getIdProd(),
                produto.getNomeProd(),
                produto.getCategoria(),
                produto.getPreco(),
                produto.getQuantidade());
        }
        System.out.println("\n---=== FIM DA LISTA ===---");
        
    }

    public void listarPorCategoria(int opCategoria){
        //Verifica se a lista de produtos está vazia
        boolean categoriaEncontrada = false;

        String categoria ="";

        switch (opCategoria) {
            case 1:
                categoria = "Alimento";
                break;
            case 2:
                categoria = "Brinquedo";
                break;
            case 3:
                categoria = "Higiene";
                break;
            case 4:
                categoria = "Acessório";
                break;
            default:
                System.out.println("Opção inválida.");
        }

        System.out.println("---== LISTA DE " + categoria.toUpperCase() + "S ==---");
        System.out.printf("| %-3s | %-10s | %-5s | %-10s | %-10s |\n", "ID", "Nome do Produto", "Preço", "Categoria", "Quantidade");
        System.out.println("|-----|------------|-------|------------|------------|");
        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.printf("| %-3d | %s | %.2f | %-10s | %d |\n",
                        produto.getIdProd(), produto.getNomeProd(), produto.getPreco(), produto.getCategoria(), produto.getQuantidade());
                categoriaEncontrada = true;
            }
        }

        if(!categoriaEncontrada) {
            System.out.println("Categoria não encontrada.");
        }

    }

    public void iniciarProdutos()
    {
        String[] nomesProdutos = { "Ração para cães", "Brinquedo para gatos", "Shampoo para cães", "Coleira para cães", "Comida para gatos", "Ração para peixes", "Casa para coelhos" };
        String[] categoriasProdutos = { "Alimento", "Brinquedo", "Higiene", "Acessório", "Alimento", "Alimento", "Acessório" };
        double[] precosProdutos = { 20.99, 15.99, 12.99, 9.99, 18.99, 10.99, 25.99 };
        int[] quantidadesProdutos = { 10, 5, 8, 12, 15, 8, 5 };
                
        // Adiciona 7 produtos prontos
        for (int i = 0; i < 7; i++) {
           Produto produto = new Produto(i + 1, nomesProdutos[i], categoriasProdutos[i], precosProdutos[i], quantidadesProdutos[i]);
           produtos.add(produto);
        }
    }



}