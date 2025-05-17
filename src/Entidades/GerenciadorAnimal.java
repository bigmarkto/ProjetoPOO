package Entidades;

import Entidades.Classes_Animais.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorAnimal implements AnimalInterface {
    private static List<Animal> listaAnimais = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Funções para o auxilio da alteração de dados dos animais
    private static Animal getById(Integer id) {
        for (Animal animal : listaAnimais) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    private static void getByNome(String nome) {
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

    private static void getByDono(String dono) {
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

    private static void getByIdade(Integer idade) {
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
                    // listaAnimais.add(new Coelho(nome, idade, donoAnimal)); TODO: MARCO
                    break;
                default:
                    System.out.println("Animal não permitido!");
            }

            System.out.println("Deseja cadastrar outro animal? \n1 - Sim \n0 - Não");
            op = sc.nextInt();
            sc.nextLine();
        } while (op != 0);
    }

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

    @Override
    public void remover() {
        // TODO: MARCO

        // Pegar qual animal deseja remover
        // Verificar se o animal existe
        // Verificar se ele estar na lista, pegar ele da lista e remover
    }

    @Override
    // Listar todos os animais
    public void listar() {
        // TODO: MARCO
        // Mostrar todos so animais em formato tabular
        // --- ID --- | --- Nome --- | --- Idade --- | --- Dono --- | --- Tipo ---
    }

    // Listar por tipo
    @Override
    public void listar(int tipo) {
        // TODO: MARCO
    }

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

    public void iniciarSistema() {
        // TODO: MARCO
        // O sistema deve gerar pelo menos 7 objetos de cada classe aleatorios quando
        // iniciado
        // 7 animais de cada tipo (7 peixes, 7 gatos, 7 cachorros, 7 pássaros e 7
        // coelhos)
        // e vai adicionar na listaAnimais
        // Exemplo: listaAnimais.add(new Cachorro("Rex", 5, new Dono("João")));

    }

}
