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
            System.out.println("---== MENU DE CADASTRO ==---");
            System.out.println("Qual o id do animal que deseja alterar? ");
            int ID = sc.nextInt();

             if (getById(ID) == null) {
                System.out.println("Animal não encontrado!");
                continue;
            }

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
    }

     @Override
    public void listar() {
        // TODO: MARCO
    }
}
