package entidades.gerenciadores;

import entidades.Produto;
import entidades.interfaces.Interface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Classes
public class GerenciadorProdutos implements Interface {

    // Atributos
    Scanner sc = new Scanner(System.in);
    private static List<Produto> produtos = new ArrayList<>();

    // Metodos
    /**
     * Exibe o menu de gerenciamento de produtos ao usuário.
     *
     * O menu oferece as opções de adicionar um produto, remover um produto,
     * listar todos os produtos e sair. O usuário pode escolher uma opção
     * digitando o número correspondente.
     *
     * Se a opção digitada for inválida, o sistema exibe uma mensagem de erro e
     * volta a exibir o menu. Caso contrário, o sistema executa a opção
     * escolhida e volta a exibir o menu.
     *
     * O loop só é interrompido quando o usuário escolhe a opção de sair.
     */
    @Override
    public void menu() {
        int p;
        do {
            System.out.println("Bem-vindo ao gerenciador de produtos! O que deseja fazer?");
            System.out.println("1 - Adicionar um produto");
            System.out.println("2 - Remover um produto");
            System.out.println("3 - Listar todos os produtos");
            System.out.println("4 - Alterar um produto");
            System.out.println("5 - Buscar um produto");
            System.out.println("0 - Sair");
            p = sc.nextInt();
            sc.nextLine();

            switch (p) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    menuListagem();
                    break;
                case 4:
                    alterar();
                    break;
                case 5:
                    buscar();
                    break;
                case 0:
                    System.out.println("Saindo do gerenciador de produtos...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (p != 0);
    }

    /**
     * Adiciona um produto ao sistema.
     *
     * O método pergunta ao usuário o nome, categoria, preco e quantidade do
     * produto e o adiciona a lista de produtos.
     *
     * Se o usuário digitar uma categoria inválida, o sistema exibe uma mensagem
     * de erro e volta a perguntar a categoria.
     *
     * Se o usuário digitar uma quantidade negativa, o sistema exibe uma
     * mensagem de erro e volta a perguntar a quantidade.
     *
     * Caso contrário, o sistema adiciona o produto a lista e exibe uma mensagem
     * de sucesso.
     *
     * O método também pergunta ao usuário se ele deseja cadastrar outro
     * produto. Se o usuário responder sim, o método volta a executar. Caso
     * contrário, o método sai do loop e retorna.
     */

     @Override
    public void cadastrar() {
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
            while (!categoria.equalsIgnoreCase("Alimento") && !categoria.equalsIgnoreCase("Brinquedo")
                    && !categoria.equalsIgnoreCase("Higiene") && !categoria.equalsIgnoreCase("Acessório")) {
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

            Produto produto = new Produto(id, nome, categoria, preco, quantidade);
            produtos.add(produto);

            System.out.println("Produto cadastrado com sucesso!");

            System.out.println("Deseja cadastrar outro produto? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
            sc.nextLine();
        } while (op != 0);
    }

    /**
     * Busca um produto por ID.
     *
     * @param id O ID do produto a ser buscado.
     * @return O produto encontrado ou null se não encontrado.
     */

    protected Produto getProdutoById(int id) {
        for (Produto idProduto : produtos) {
            if (idProduto.getIdProd() == id) {
                return idProduto;
            }
        }
        return null;
    }


    protected void getByNomeProd(String nomeProd) {
        boolean produtoEncontrado = false;
        System.out.println("---== PRODUTO ENCONTRADO ==---");
        System.out.printf("| %-3s | %-10s | %-10s | %-5s | %-8s |\n", "ID", "Nome", "Categoria", "Preço", "Quantidade");
        System.out.println("|-----|------------|------------|-------|----------|");
            for (Produto produto : produtos) {
                if (produto.getNomeProd().equalsIgnoreCase(nomeProd)) {
                    System.out.printf("| %-3d | %-10s | %-10s | %-5.2f | %-8d |\n", produto.getIdProd(), produto.getNomeProd(), produto.getCategoria(), produto.getPreco(), produto.getQuantidade());
                    produtoEncontrado = true;
        }
    }
    if (!produtoEncontrado) {
        System.out.println("Produto não encontrado.");
    }
    }

    protected void getByPreco(Double preco) {
        boolean produtoEncontrado = false;
        System.out.println("---== PRODUTO ENCONTRADO ==---");
        System.out.printf("| %-3s | %-10s | %-10s | %.2f | %-8s |\n", "ID", "Nome", "Categoria", "Preço", "Quantidade");
        System.out.println("|-----|------------|------------|-------|----------|");
        for (Produto produto : produtos) {
            if (produto.getPreco() == preco) {
                System.out.printf("| %-3d | %-10s | %-10s | %.2f | %-8d |\n", produto.getIdProd(), produto.getNomeProd(), produto.getCategoria(), produto.getPreco(), produto.getQuantidade());
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado) {
            System.out.println("Produto nao encontrado.");
        }
    }
    /**
     * Remove um produto existente.
     *
     * Exibe um menu para selecionar o ID do produto a ser removido. Após a
     * remoção, mostra a mensagem de sucesso e após, o usuario é perguntado se
     * deseja remover outro produto.
     */
    @Override
    public void remover() {

        int op = 1;
        do {
            listar();
            // Verifica se a lista de produtos está vazia
            if (produtos.isEmpty()) {
                // Se estiver vazia, exibe uma mensagem e retorna
                System.out.println("Nenhum produto cadastrado.");
                return;
            }
            // Exibe os produtos cadastrados ao usuário para que ele escolha qual deseja
            // remover
            System.out.println("Digite o ID do produto que deseja remover: ");
            int id = sc.nextInt();
            sc.nextLine();

            // Busca o produto pelo ID
            Produto produtoParaCancelar = null;
            for (Produto produto : produtos) {
                if (produto.getIdProd() == id) {
                    produtoParaCancelar = produto;
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

    /**
     * Exibe um menu para o usuario escolher uma opção de listagem de produtos.
     *
     * O menu oferece as opções de listar todos os produtos, listar produtos por
     * categoria e voltar.
     *
     * Se a opção digitada for inválida, o sistema exibe uma mensagem de erro e
     * volta a exibir o menu. Caso contrário, o sistema executa a opção
     * escolhida e volta a exibir o menu.
     *
     * O loop só é interrompido quando o usuario escolhe a opção de sair.
     */
    public void menuListagem() {
        int op;
        do {
            System.out.println("Escolha uma opção de listagem:");
            System.out.println("1 - Listar todos os produtos");
            System.out.println("2 - Listar produtos por categoria");
            System.out.println("0 - Voltar");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    listar();
                    break;
                case 2:
                    System.out.println("Escolha uma categoria:");
                    System.out.println("1 - Alimento");
                    System.out.println("2 - Brinquedo");
                    System.out.println("3 - Higiene");
                    System.out.println("4 - Acessório");
                    int opCategoria = sc.nextInt();
                    sc.nextLine();
                    listar(opCategoria);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (op != 0);
    }

    /**
     * Exibe todos os produtos cadastrados no sistema.
     *
     * Verifica se a lista de produtos está vazia. Se estiver vazia, exibe uma
     * mensagem e sai do método.
     *
     * Caso contrário, exibe todos os produtos cadastrados em uma lista,
     * mostrando o ID, o nome, a categoria, o preço e a quantidade de cada
     * produto.
     */
    @Override
    public void listar() {
        // Verifica se a lista de produtos está vazia
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        // Exibe os produtos cadastrados ao usuário
        System.out.println("---=== LISTA DE PRODUTOS ===---");
        for (Produto produto : produtos) {
            System.out.printf("ID: %d | Nome: %s | Categoria: %s | Preço: %.2f | Quantidade: %s \n",
                    produto.getIdProd(),
                    produto.getNomeProd(),
                    produto.getCategoria(),
                    produto.getPreco(),
                    produto.getQuantidade());
        }
        System.out.println("\n---=== FIM DA LISTA ===---");

    }

    /**
     * Exibe todos os produtos cadastrados em uma categoria específica.
     *
     * Se a lista de produtos estiver vazia, exibe uma mensagem e sai do método.
     *
     * Caso contrário, exibe todos os produtos cadastrados que pertencem a
     * categoria escolhida pelo usuário em uma lista, mostrando o ID, o nome, o
     * preço e a quantidade de cada produto.
     *
     * @param opCategoria O número da categoria escolhida pelo usuário (1 -
     * Alimento, 2 - Brinquedo, 3 - Higiene, 4 - Acessório).
     */
    @Override
    public void listar(int opCategoria) {
        // Verifica se a lista de produtos está vazia
        boolean categoriaEncontrada = false;

        String categoria = "";

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
        System.out.printf("| %-3s | %-10s | %-5s | %-10s | %-10s |\n", "ID", "Nome do Produto", "Preço", "Categoria",
                "Quantidade");
        System.out.println("|-----|------------|-------|------------|------------|");
        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.printf("| %-3d | %s | %.2f | %-10s | %d |\n",
                        produto.getIdProd(), produto.getNomeProd(), produto.getPreco(), produto.getCategoria(),
                        produto.getQuantidade());
                categoriaEncontrada = true;
            }
        }

        if (!categoriaEncontrada) {
            System.out.println("Categoria não encontrada.");
        }

    }



/**
 * Modifica as informações de um produto existente.
 *
 * Permite ao usuário alterar o nome, categoria, preço e quantidade de um 
 * produto já cadastrado no sistema. 
 * 
 * O método exibe um menu para que o usuário selecione o produto a ser alterado 
 * por meio de seu ID. 
 * 
 * Após a seleção, o sistema solicita as novas informações do produto e as 
 * atualiza na lista de produtos.
 */
    @Override
    public void alterar() {
        Integer op = 1, aspecto;

        do{
            System.out.println("---== MENU DE ALTERAÇÃO ==---");
            System.out.println("Qual o id do produto que deseja alterar?");
            int idP = sc.nextInt();

            if (getProdutoById(idP) == null){
                System.out.println("Produto não encontrado!");
                continue;
            }

            System.out.println("Produto selecionado: " + getProdutoById(idP).getNomeProd());
            System.out.println("Qual aspecto deseja alterar? \n 1 - Nome \n 2 - Categoria \n 3 - Preço \n 4 - Quantidade");
            aspecto = sc.nextInt();
            sc.nextLine();
            switch (aspecto) {
                case 1:
                    System.out.println("Qual o nome do produto?");
                    String nome = sc.nextLine();
                    getProdutoById(idP).setNomeProd(nome);
                    break;
                case 2:
                    System.out.println("Qual a categoria do produto? (Digite o nome da categoria)");
                    System.out.println("1 - Alimento \n 2 - Brinquedo \n 3 - Higiene \n 4 - Acessório");
                    String categoria = sc.nextLine();
                    getProdutoById(idP).setCategoria(categoria);
                    break;
                case 3:
                    System.out.println("Qual o preco do produto?");
                    double preco = sc.nextDouble();
                    getProdutoById(idP).setPreco(preco);
                    break;
                case 4:
                    System.out.println("Qual a quantidade do produto?");
                    int quantidade = sc.nextInt();
                    getProdutoById(idP).setQuantidade(quantidade);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }


            System.out.println("Deseja alterar outro produto? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
        } while (op != 0);
    }

    @Override
    public void buscar() {
        int op = 1;

        do {

            System.out.println("---== MENU DE BUSCA ==---");
            System.out.println("Deseja buscar por:  \n 1 - Nome \n 2 - Preço");
            int aspecto = sc.nextInt();
            sc.nextLine();
            String busca;
            switch (aspecto) {
                case 1:
                    System.out.println("Qual o nome do produto? ");
                    busca = sc.nextLine();
                    getByNomeProd(busca);

                    break;
                case 2:
                    System.out.println("Qual o preco do produto? ");
                    busca = sc.nextLine();
                    Double preco = Double.parseDouble(busca);
                    getByPreco(preco); 
                    break;                  

                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println("Deseja buscar outro produto? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
        } while (op != 0);
    };

    /**
     * Inicializa o sistema com uma lista de produtos predefinidos.
     *
     * Este método cria sete produtos predefinidos com nomes, categorias, preços
     * e quantidades específicas e os adiciona à lista de produtos. Cada produto
     * é instanciado com um ID único, nome, categoria, preço e quantidade.
     */
    public void iniciarProdutos() {
        String[] nomesProdutos = {"Ração para cães", "Brinquedo para gatos", "Shampoo para cães", "Coleira para cães",
            "Comida para gatos", "Ração para peixes", "Casa para coelhos"};
        String[] categoriasProdutos = {"Alimento", "Brinquedo", "Higiene", "Acessório", "Alimento", "Alimento",
            "Acessório"};
        double[] precosProdutos = {20.99, 15.99, 12.99, 9.99, 18.99, 10.99, 25.99};
        int[] quantidadesProdutos = {10, 5, 8, 12, 15, 8, 5};

        // Adiciona 7 produtos prontos
        for (int i = 0; i < 7; i++) {
            Produto produto = new Produto(i + 1, nomesProdutos[i], categoriasProdutos[i], precosProdutos[i],
                    quantidadesProdutos[i]);
            produtos.add(produto);
        }
    }
}
