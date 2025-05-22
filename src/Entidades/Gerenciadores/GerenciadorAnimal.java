package Entidades.Gerenciadores;

import Entidades.Animal;
import Entidades.Dono;
import Entidades.Classes_Animais.*;
import Entidades.Interfaces.AnimalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class GerenciadorAnimal implements AnimalInterface {

    // Atributos
    private static List<Animal> listaAnimais = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    /**
     * Funções para o auxilio da alteração de dados dos animais
     *
     * Procura um animal pela sua ID e retorna ele.
     * 
     * @param id A ID do animal a ser procurado.
     * @return O animal encontrado ou null caso n o encontre.
     */
    protected Animal getById(Integer id) {
        for (Animal animal : listaAnimais) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    protected Animal getAnimalByNameAndDono(String nome, String dono) {
        for (Animal animal : listaAnimais) {
            if (animal.getNome().equalsIgnoreCase(nome) && animal.getDono().getNome().equalsIgnoreCase(dono)) {
                return animal;
            }
        }
        return null;
    }

    /**
     * Procura um animal pelo seu nome e exibe suas informações
     * em formato tabular se encontrado.
     *
     * @param nome O nome do animal a ser procurado.
     */
    protected void getByNome(String nome) {
        boolean encontrou = false;
        System.out.printf("| %-3s | %-10s | %-5s | %-10s | %-10s |\n", "ID", "Nome", "Idade", "Dono", "Tipo");
        System.out.println("|-----|------------|-------|------------|------------|");
        for (Animal animal : listaAnimais) {
            if (animal.getNome().equalsIgnoreCase(nome)) {
                System.out.printf("| %-3d | %-10s | %-5d | %-10s | %-10s |\n",
                        animal.getId(), animal.getNome(), animal.getIdade(), animal.getDono().getNome(),
                        animal.getTipo());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum animal encontrado com o nome informado.");
        }
    }

    /**
     * Procura um animal pelo seu dono e exibe suas informações
     * em formato tabular se encontrado.
     *
     * @param dono O nome do dono do animal a ser procurado.
     */
    protected void getByDono(String dono) {
        boolean encontrou = false;
        System.out.printf("| %-3s | %-10s | %-5s | %-10s | %-10s |\n", "ID", "Nome", "Idade", "Dono", "Tipo");
        System.out.println("|-----|------------|-------|------------|------------|");
        for (Animal animal : listaAnimais) {
            if (animal.getDono().getNome().equalsIgnoreCase(dono)) {
                System.out.printf("| %-3d | %-10s | %-5d | %-10s | %-10s |\n",
                        animal.getId(), animal.getNome(), animal.getIdade(), animal.getDono().getNome(),
                        animal.getTipo());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum animal encontrado com o dono informado.");
        }
    }

    /**
     * Procura um animal pela sua idade e exibe suas informa es
     * em formato tabular se encontrado.
     *
     * @param idade A idade do animal a ser procurado.
     */
    protected void getByIdade(Integer idade) {
        boolean encontrou = false;
        System.out.printf("| %-3s | %-10s | %-5s | %-10s | %-10s |\n", "ID", "Nome", "Idade", "Dono", "Tipo");
        System.out.println("|-----|------------|-------|------------|------------|");
        for (Animal animal : listaAnimais) {
            if (animal.getIdade() == (idade)) {
                System.out.printf("| %-3d | %-10s | %-5d | %-10s | %-10s |\n",
                        animal.getId(), animal.getNome(), animal.getIdade(), animal.getDono().getNome(),
                        animal.getTipo());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum animal encontrado com a idade informada.");
        }
    }

    /**
     * Cadastra um novo animal.
     *
     * Mostra um menu para escolher o tipo do animal e
     * suas informações. Após preencher as informações,
     * o usuário é perguntado se deseja cadastrar outro
     * animal.
     */
    @Override
    public void cadastrar() {
        String nome, dono;
        Integer op = 1, idade, tipo;

        do {
            System.out.println("---== MENU DE CADASTRO ==---");
            System.out.println("Qual o nome do animal? ");
            nome = sc.nextLine();
            System.out.println("Qual a idade do animal? ");
            idade = sc.nextInt();
            System.out.println("Qual o tipo do animal?");
            System.out.printf("1 - Cachorro \n2 - Gato \n3 - Peixe \n4 - Pássaro\n5 - Coelho\n");
            tipo = sc.nextInt();
            sc.nextLine();

            System.out.println("Qual o nome do dono? ");
            dono = sc.nextLine();
            Dono donoAnimal = new Dono(dono);

            switch (tipo) {
                case 1:
                    listaAnimais.add(new Cachorro(nome, idade, donoAnimal));
                    break;
                case 2:
                    listaAnimais.add(new Gato(nome, idade, donoAnimal));
                    break;
                case 3:
                    listaAnimais.add(new Peixe(nome, idade, donoAnimal));
                    break;
                case 4:
                    listaAnimais.add(new Passaro(nome, idade, donoAnimal));
                    break;
                case 5:
                    listaAnimais.add(new Coelho(nome, idade, donoAnimal));
                    break;
                default:
                    System.out.println("Animal não permitido!");
            }

            System.out.println("Deseja cadastrar outro animal? \n1 - Sim \n0 - Não");
            op = sc.nextInt();
            sc.nextLine();
        } while (op != 0);
    }

    /**
     * Altera as informações de um animal existente.
     *
     * Exibe um menu para selecionar o ID do animal e o aspecto que se deseja
     * alterar
     * (nome, idade ou dono). Após a alteração, o usuário é perguntado se deseja
     * alterar outro animal.
     */
    @Override
    public void alterar() {
        String dono, nome;
        Integer op = 1, idade, aspecto;

        do {
            System.out.println("---== MENU DE ALTERAÇÃO ==---");
            System.out.println("Qual o id do animal que deseja alterar? ");
            int ID = sc.nextInt();

            if (getById(ID) == null) {
                System.out.println("Animal não encontrado!");
                continue;
            }

            System.out.println("Animal Selecionado: " + getById(ID).getNome());
            System.out.println("Qual aspecto deseja alterar? \n 1 - Nome \n 2 - Idade \n 3- Dono");
            aspecto = sc.nextInt();
            sc.nextLine();

            switch (aspecto) {
                case 1:
                    System.out.println("Qual o nome do animal? ");
                    nome = sc.nextLine();

                    getById(ID).setNome(nome);
                    break;
                case 2:
                    System.out.println("Qual a idade do animal? ");
                    idade = sc.nextInt();
                    getById(ID).setIdade(idade);
                    break;
                case 3:
                    System.out.println("Qual o nome do dono? ");
                    dono = sc.nextLine();
                    getById(ID).setDono(new Dono(dono));
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println("Deseja alterar outro animal? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
        } while (op != 0);
    }

    /**
     * Remove um animal existente.
     *
     * Exibe um menu para selecionar o ID do animal a ser removido.
     * Após a remoção, mostra a mensagem de sucesso e após, o usuario é perguntado
     * se deseja
     * remover outro animal.
     */
    @Override
    public void remover() {

        // Pegar qual animal deseja remover
        int op = 1;
        do {
            System.out.println("---== MENU DE REMOÇÃO ==---");
            System.out.println("Qual o ID do animal que deseja remover? ");
            int id = sc.nextInt();

            // Verificar se o animal existe
            // Verificar se ele estar na lista, pegar ele da lista e remover
            Animal animal = getById(id);
            if (animal == null) {
                System.out.println("Animal não encontrado!");
            } else {
                listaAnimais.remove(animal);
                System.out.println("Animal removido com sucesso!");
            }
            System.out.println("Deseja remover outro animal? \n1 - Sim \n0 - Não");
            op = sc.nextInt();
        } while (op != 0);
    }

    /**
     * Exibe todos os animais cadastrados em formato tabular.
     * 
     * Se a lista de animais estiver vazia, exibe a mensagem "Nenhum animal
     * cadastrado."
     * Caso contrário, exibe a tabela com as colunas ID, Nome, Idade, Dono e Tipo.
     */
    @Override
    // Listar todos os animais
    public void listar() {
        if (listaAnimais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }

        System.out.println("---== LISTA DE ANIMAIS ==---");
        System.out.printf("| %-3s | %-10s | %-5s | %-10s | %-10s |\n", "ID", "Nome", "Idade", "Dono", "Tipo");
        System.out.println("|-----|------------|-------|------------|------------|");
        for (Animal animal : listaAnimais) {
            System.out.printf("| %-3d | %-10s | %-5d | %-10s | %-10s |\n", animal.getId(), animal.getNome(),
                    animal.getIdade(), animal.getDono().getNome(), animal.getTipo());
        }

    }

    /**
     * Listar por tipo
     * 
     * Exibe todos os animais de um tipo específico em formato tabular.
     * 
     * O tipo do animal é determinado pelo parâmetro `tipo`, que deve
     * corresponder a um dos seguintes valores: 1 (Cachorro), 2 (Gato),
     * 3 (Peixe), 4 (Pássaro), ou 5 (Coelho). Se um tipo inválido for
     * fornecido, uma mensagem de erro será exibida.
     * 
     * Se não houver animais do tipo especificado, uma mensagem
     * indicando que nenhum animal foi encontrado será exibida.
     * 
     * @param tipo O código numérico representando o tipo de animal a ser listado.
     */
    @Override
    public void listar(int tipo) {

        boolean encontrou = false;
        String tipoAnimal = "";
        switch (tipo) {
            case 1:
                tipoAnimal = "Cachorro";
                break;
            case 2:
                tipoAnimal = "Gato";
                break;
            case 3:
                tipoAnimal = "Peixe";
                break;
            case 4:
                tipoAnimal = "Pássaro";
                break;
            case 5:
                tipoAnimal = "Coelho";
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        System.out.println("---== LISTA DE " + tipoAnimal.toUpperCase() + "S ==---");
        System.out.printf("| %-3s | %-10s | %-5s | %-10s | %-10s |\n", "ID", "Nome", "Idade", "Dono", "Tipo");
        System.out.println("|-----|------------|-------|------------|------------|");
        for (Animal animal : listaAnimais) {
            if (animal.getTipo().equalsIgnoreCase(tipoAnimal)) {
                System.out.printf("| %-3d | %-10s | %-5d | %-10s | %-10s |\n",
                        animal.getId(), animal.getNome(), animal.getIdade(), animal.getDono().getNome(),
                        animal.getTipo());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum " + tipoAnimal + " encontrado.");
        }

    }

    /**
     * Realiza a busca de animais com base no critério escolhido pelo usuário.
     *
     * Exibe um menu para o usuário selecionar o critério de busca: nome, idade ou
     * dono.
     * Após selecionar o critério, solicita ao usuário o valor correspondente para
     * busca
     * e exibe os animais encontrados utilizando métodos específicos de busca.
     * O usuário é perguntado se deseja realizar outra busca após cada operação.
     */
    public void buscar() {
        int op = 1;

        do {
            System.out.println("---== MENU DE BUSCA ==---");
            System.out.println("Deseja buscar por:  \n1 - Nome \n 2 - Idade \n 3- Dono");
            int aspecto = sc.nextInt();
            sc.nextLine();
            String busca;
            switch (aspecto) {
                case 1:
                    System.out.println("Qual o nome do animal? ");
                    busca = sc.nextLine();
                    getByNome(busca);

                    break;
                case 2:
                    System.out.println("Qual a idade do animal? ");
                    busca = sc.nextLine();
                    Integer idade = Integer.parseInt(busca);
                    getByIdade(idade);

                    break;
                case 3:
                    System.out.println("Qual o nome do dono? ");
                    busca = sc.nextLine();
                    getByDono(busca);

                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println("Deseja buscar outro animal? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
        } while (op != 0);
    }

    /**
     * Inicializa o sistema com 7 animais de cada tipo (7 peixes, 7 gatos, 7
     * cachorros, 7 pássaros e 7 coelhos).
     * 
     * Os animais são cadastrados com nome, idade e dono aleatórios.
     */
    public void iniciarSistema() {
        String[] nomesCachorro = { "Rex", "Luna", "Max", "Bella", "Toby", "Nina", "Rocky" };
        String[] nomesGato = { "Miau", "Simba", "Lola", "Tigrinha", "Ginger", "Salem", "Felix" };
        String[] nomesPeixe = { "Nemo", "Bubbles", "Goldie", "Finny", "Splash", "Coral", "Dory" };
        String[] nomesPassaro = { "Piu", "Tweety", "Sky", "Sunny", "Blue", "Kiwi", "Rio" };
        String[] nomesCoelho = { "Floquinho", "Cenoura", "Snowball", "Bunny", "Puffy", "Hopper", "Marshmallow" };
        String[] nomesDonos = { "João", "Maria", "Ana", "Pedro", "Lucas", "Sofia", "Clara" };
        Random random = new Random();

        // Adiciona 7 animais de cada tipo
        for (int i = 0; i < 7; i++) {
            // Cachorros
            listaAnimais.add(new Cachorro(
                    nomesCachorro[i],
                    random.nextInt(10) + 1,
                    new Dono(nomesDonos[random.nextInt(nomesDonos.length)])));
            // Gatos
            listaAnimais.add(new Gato(
                    nomesGato[i],
                    random.nextInt(10) + 1,
                    new Dono(nomesDonos[random.nextInt(nomesDonos.length)])));
            // Peixes
            listaAnimais.add(new Peixe(
                    nomesPeixe[i],
                    random.nextInt(5) + 1,
                    new Dono(nomesDonos[random.nextInt(nomesDonos.length)])));
            // Pássaros
            listaAnimais.add(new Passaro(
                    nomesPassaro[i],
                    random.nextInt(8) + 1,
                    new Dono(nomesDonos[random.nextInt(nomesDonos.length)])));
            // Coelhos
            listaAnimais.add(new Coelho(
                    nomesCoelho[i],
                    random.nextInt(6) + 1,
                    new Dono(nomesDonos[random.nextInt(nomesDonos.length)])));
        }

    }

    public void menuInicializar() {
        int op;

        do {
            System.out.println("---=== MENU DE GERENCIAMENTO CLIENTE ===---");
            System.out.println("1 - Cadastrar um cliente");
            System.out.println("2 - Alterar um cliente");
            System.out.println("3 - Listar todos os clientes");
            System.out.println("4 - Listar clientes por tipo");
            System.out.println("5 - Buscar um cliente");
            System.out.println("6 - Remover um cliente");
            System.out.println("0 - Voltar");
            System.out.println("Escolha uma opção: ");
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
                    listar();
                    break;
                case 4:
                    System.out.println("Qual o tipo de animal? ");
                    System.out.printf("1 - Cachorro \n2 - Gato \n3 - Peixe \n4 - Pássaro\n5 - Coelho\n");
                    int tipo = sc.nextInt();
                    listar(tipo);
                    break;
                case 5:
                    buscar();
                    break;
                case 6:
                    remover();
                    break;
                case 0:
                    System.out.println("Voltando....");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (op != 0);
    }
}
