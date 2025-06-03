package entidades.gerenciadores;

import entidades.Produto;
import entidades.interfaces.Interface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorCompra implements Interface
{

    //Atributos
    Scanner sc = new Scanner(System.in);
    private static List<Produto> listarProdutos = new ArrayList<>();
    GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();
    private static List<Produto> carrinhosProdutos = new ArrayList<>();

    //Metodos
    
    /**
     * Retorna a lista de produtos comprados.
     *
     * @return A lista de produtos comprados.
     */
    protected Produto getById(Integer id) {
        for (Produto produto : carrinhosProdutos) {
            if (produto.getIdProd() == id) {
                return produto;
            }
        }
        return null;
    }
    
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
    @Override
    public void menu() {
        int op;
        do {
        System.out.println("---=== MENU DE COMPRAS DE PRODUTOS ===---");
        System.out.println("1 - Comprar produto");
        System.out.println("2 - Alterar produto");
        System.out.println("3 - Remover produto");
        System.err.println("4 - Listar Carrinho de Compras");
        System.err.println("5 - Listar Compras por Categoria");
        System.out.println("0 - Sair");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                cadastrar();
                break;
            case 2:
                alterar();
                break;
            case 3:
                remover();
                break;
            case 4:
                listar();
                break;
            case 5:
            System.out.println("Qual o tipo de Categoria? ");
            System.out.printf("1 - Alimento \n2 - Brinquedo \n3 - Higiene \n4 - Acessório\n");
            int tipo = sc.nextInt();
            listar(tipo);
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
    @Override
    public void cadastrar() {
        int op = 1;
        do {
        GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();
        gerenciadorProdutos.listar(); // Lista todos os produtos disponíveis
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
            Produto produtoCarrinho = new Produto(
                produto.getIdProd(),
                produto.getNomeProd(),
                produto.getCategoria(),
                produto.getPreco(),
                quantity // quantidade comprada
            );
            carrinhosProdutos.add(produtoCarrinho);

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

    /**
     * Altera a quantidade de um produto no carrinho.
     *
     * Exibe um menu para selecionar o ID do produto a ser alterado. Após a
     * escolha, pergunta se o usuário deseja aumentar ou diminuir a quantidade.
     *
     * Se a opção for aumentar, pergunta a quantidade a ser adicionada. Se for
     * diminuir, pergunta a quantidade a ser subtraída. Atualiza a quantidade do
     * produto no carrinho e exibe uma mensagem de sucesso.
     *
     * Após a alteração, pergunta ao usuário se deseja alterar outro produto.
     * Se a resposta for sim, o loop se repete. Caso contrário, o loop é
     * interrompido e o usuario volta ao menu principal.
     */
    @Override
    public void alterar() {

        int op = 1;
        do {
            System.out.println("---== MENU DE ALTERAÇÃO DO CARRINHO ==---");
            System.out.println("Qual o id do produto do carrinho que deseja alterar? ");
            int ID = sc.nextInt();

            if (getById(ID) == null) {
                System.out.println("Produto no carrinho não encontrado!");
                continue;
            }

            Produto produto = gerenciadorProdutos.getProdutoById(ID); 

            System.out.println("Produto Selecionado: " + getById(ID).getNomeProd());

            System.out.println("O usuário quer Aumentar ou Diminuir? \n 1 - Aumentar \n 2 - Diminuir \n");
            int aspecto = sc.nextInt();
            sc.nextLine();

            switch (aspecto) {
                
                case 1:
                    System.out.println("Qual a Quantidade a ser aumentada? ");
                    int qntmais = sc.nextInt();
                    sc.nextLine();

                    getById(ID).setQuantidade(getById(ID).getQuantidade() + qntmais);
                break;

                case 2:
                    System.out.println("Qual a Quantidade a ser diminuida? ");
                    int qntmenos = sc.nextInt();
                    sc.nextLine();

                    getById(ID).setQuantidade(getById(ID).getQuantidade() - qntmenos);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                return;
            }

            System.out.println("Produto alterado com sucesso!");
            System.out.printf("ID: %d | Nome: %s | Categoria: %s | Preço: %.2f | Quantidade: %s \n",
                    getById(ID).getIdProd(),
                    getById(ID).getNomeProd(),
                    getById(ID).getCategoria(),
                    (getById(ID).getPreco() * getById(ID).getQuantidade()),
                    getById(ID).getQuantidade());

            
            System.out.println("Deseja alterar outro produto? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
            sc.nextLine();
        } while (op != 0);
    };
    
    /**
     * Remove um produto do carrinho de compras.
     *
     * Exibe um menu para selecionar o ID do produto a ser removido. Após a
     * escolha, verifica se o produto existe no carrinho. Se existir, remove o
     * produto e exibe uma mensagem de sucesso. Caso contrário, exibe uma
     * mensagem de erro.
     *
     * Após a remoção, pergunta ao usuário se deseja remover outro produto.
     * Se a resposta for sim, o loop se repete. Caso contrário, o loop é
     * interrompido e o usuario volta ao menu principal.
     */
    @Override
    public void remover() {
        // Pegar qual animal deseja remover
        int op = 1;
        do {
            System.out.println("---== MENU DE REMOÇÃO ==---");
            System.out.println("Qual o ID da compra que deseja remover? ");
            int id = sc.nextInt();

            // Verificar se o animal existe
            // Verificar se ele estar na lista, pegar ele da lista e remover
            Produto produtoCarrinho = getById(id);
            if (produtoCarrinho == null) {
                System.out.println("Produto no carrinho não encontrado!");
            } else {
                carrinhosProdutos.remove(produtoCarrinho);
                System.out.println("Produto do carrinho removido com sucesso!");
            }
            System.out.println("Deseja remover outro produto do carrinho? \n1 - Sim \n0 - Não");
            op = sc.nextInt();
        } while (op != 0);
    };

    /**
     * Lista os produtos no carrinho de compras.
     *
     * Exibe todos os produtos que foram comprados, mostrando o ID, nome,
     * categoria, preço e quantidade de cada produto.
     *
     * Se não houver produtos no carrinho, exibe uma mensagem informando que
     * o carrinho está vazio.
     */
    @Override
    public void listar() {
        
        // Verifica se a lista de produtos está vazia
        if (carrinhosProdutos.isEmpty()) {
            System.out.println("Nenhum produto no carrinho.");
            return;
        }

        // Exibe os produtos cadastrados ao usuário
        System.out.println("---=== CARRINHO ===---");

        for (Produto produto : carrinhosProdutos) {
            System.out.printf("ID: %d | Nome: %s | Categoria: %s | Preço: %.2f | Quantidade: %s \n",
                    produto.getIdProd(),
                    produto.getNomeProd(),
                    produto.getCategoria(),
                    (produto.getPreco() * produto.getQuantidade()),
                    produto.getQuantidade());
        }
        System.out.println("\n---=== FIM DO CARRINHO ===---");

    };

    /**
     * Lista os produtos no carrinho de compras de uma categoria especifica.
     *
     * Exibe todos os produtos que foram comprados, mostrando o ID, nome,
     * categoria, preço e quantidade de cada produto.
     *
     * Se nao houver produtos no carrinho, exibe uma mensagem informando que
     * o carrinho esta vazio.
     */
    @Override
    public void listar(int tipo) {

        boolean encontrou = false;
        String categoriaCompras = "";
        
        switch (tipo) {
            
            case 1:
                categoriaCompras = "Alimento";
                break;
            case 2:
                categoriaCompras = "Brinquedo";
                break;
            case 3:
                categoriaCompras = "Higiene";
                break;
            case 4:
                categoriaCompras = "Acessório";
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        System.out.println("---== LISTA DE " + categoriaCompras.toUpperCase() + "S ==---");
        System.out.printf("| %-3s | %-10s | %-5s | %-10s | %-10s |\n", "ID", "Nome", "Preço", "Quantidade", "Categoria");
        System.out.println("|-----|------------|-------|------------|------------|");
        for (Produto produto : carrinhosProdutos) {
            if (produto.getCategoria().equalsIgnoreCase(categoriaCompras)) {
                System.out.printf("| %-3d | %-10s | %-5.2f | %-10d | %-10s |\n",
                        produto.getIdProd(), produto.getNomeProd(), (produto.getPreco() * produto.getQuantidade()), produto.getQuantidade(),
                        produto.getCategoria());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum " + categoriaCompras + " encontrado.");
        }

    }

    

    /**
     * Método vazio, pois não é necessário implementar a busca de compras.
     * Este método é parte da interface Interface, mas não é utilizado neste
     * gerenciador.
     */
    @Override
    public void buscar() {};
    
}