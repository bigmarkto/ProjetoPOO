package Entidades;

import Entidades.Classes_Animais.*;
import Entidades.Animal;
import Entidades.Dono;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


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

    @Override
    // Listar todos os animais
    public void listar() {
        // TODO: MARCO
        // Mostrar todos so animais em formato tabular
        // --- ID --- | --- Nome --- | --- Idade --- | --- Dono --- | --- Tipo ---
        if (listaAnimais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }

        System.out.println("---== LISTA DE ANIMAIS ==---");
        System.out.printf("| %-3s | %-10s | %-5s | %-10s | %-10s |\n", "ID", "Nome", "Idade", "Dono", "Tipo");
        System.out.println("|-----|------------|-------|------------|------------|");
            for (Animal animal : listaAnimais) {
                System.out.printf("| %-3d | %-10s | %-5d | %-10s | %-10s |\n", animal.getId(), animal.getNome(), animal.getIdade(), animal.getDono().getNome(), animal.getTipo());
        }

    }

    // Listar por tipo
    @Override
    public void listar(int tipo) {
        // TODO: MARCO
        boolean encontrou = false;
        String tipoAnimal = "";
        switch (tipo) {
            case 1: tipoAnimal = "Cachorro"; break;
            case 2: tipoAnimal = "Gato"; break;
            case 3: tipoAnimal = "Peixe"; break;
            case 4: tipoAnimal = "Pássaro"; break;
            case 5: tipoAnimal = "Coelho"; break;
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
        // 7 animais de cada tipo (7 peixes, 7 gatos, 7 cachorros, 7 pássaros e 7
        // coelhos)
        // e vai adicionar na listaAnimais
        // Exemplo: listaAnimais.add(new Cachorro("Rex", 5, new Dono("João")));
            String[] nomesCachorro = {"Rex", "Luna", "Max", "Bella", "Toby", "Nina", "Rocky"};
            String[] nomesGato = {"Miau", "Simba", "Lola", "Tigrinha", "Ginger", "Salem", "Felix"};
            String[] nomesPeixe = {"Nemo", "Bubbles", "Goldie", "Finny", "Splash", "Coral", "Dory"};
            String[] nomesPassaro = {"Piu", "Tweety", "Sky", "Sunny", "Blue", "Kiwi", "Rio"};
            String[] nomesCoelho = {"Floquinho", "Cenoura", "Snowball", "Bunny", "Puffy", "Hopper", "Marshmallow"};
            String[] nomesDonos = {"João", "Maria", "Ana", "Pedro", "Lucas", "Sofia", "Clara"};
                Random random = new Random();

        // Adiciona 7 animais de cada tipo
        for (int i = 0; i < 7; i++) {
            // Cachorros
            listaAnimais.add(new Cachorro(
                    nomesCachorro[i],
                    random.nextInt(10) + 1,
                    new Dono(nomesDonos[random.nextInt(nomesDonos.length)])
            ));
            // Gatos
            listaAnimais.add(new Gato(
                    nomesGato[i],
                    random.nextInt(10) + 1,
                    new Dono(nomesDonos[random.nextInt(nomesDonos.length)])
            ));
            // Peixes
            listaAnimais.add(new Peixe(
                    nomesPeixe[i],
                    random.nextInt(5) + 1,
                    new Dono(nomesDonos[random.nextInt(nomesDonos.length)])
            ));
            // Pássaros
            listaAnimais.add(new Passaro(
                    nomesPassaro[i],
                    random.nextInt(8) + 1,
                    new Dono(nomesDonos[random.nextInt(nomesDonos.length)])
            ));
            // Coelhos
            listaAnimais.add(new Coelho(
                    nomesCoelho[i],
                    random.nextInt(6) + 1,
                    new Dono(nomesDonos[random.nextInt(nomesDonos.length)])
            ));
        }
        
    }
    

}
