package Entidades;

import Entidades.Classes_Animais.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorAnimal implements AnimalInterface {
    private List<Animal> listaAnimais = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

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
            System.out.println("Qual o tipo do animal? ");
            System.out.printf("1 - Cachorro \n 2 - Gato \n 3 - Peixe \n 4 - Pássaro\n");
            tipo = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do scanner

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
                  //  listaAnimais.add(new Peixe(nome, idade, donoAnimal));
                    break;
                case 4:
                  //  listaAnimais.add(new Passaro(nome, idade, donoAnimal));
                    break;
                default:
                    System.out.println("Animal não permitido!");
            }

            System.out.println("Deseja cadastrar outro animal? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
        } while (op != 0);
    }

     @Override
    public void alterar() {
        
    }

     @Override
    public void remover() {
        
    }

     @Override
    public void listar() {
        
    }
}
