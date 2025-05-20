package Executor;

import java.util.Scanner;

import Entidades.GerenciadorAnimal;

public class Programa {
    public static void main(String[] args) {
        // Váriaveis iniciais
        int op;

        // Menu de opções
        Scanner sc = new Scanner(System.in);

        // Instancia o gerenciador de animais
        GerenciadorAnimal gerenciador = new GerenciadorAnimal();
        gerenciador.iniciarSistema();

        do {

            System.out.println("---== MENU DE OPÇÕES ==---");
            System.out.println("1 - Cadastrar animal no sistema");
            System.out.println("2 - Alterar informações do animal");
            System.out.println("3 - Listar animais do sistema");
            System.out.println("4 - Buscar animais no sistema");
            System.out.println("5 - Remover animal do sistema");
            System.out.println("6 - Listar animais por tipo");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            System.out.printf("\n\n\n\n");
            switch (op) {
                case 1:
                    gerenciador.cadastrar();
                    break;
                case 2:
                    gerenciador.alterar();
                    break;
                case 3:
                    gerenciador.listar();
                    break;
                case 4:
                    gerenciador.buscar();
                    break;
                case 5:
                    gerenciador.remover();
                    break;
                case 6:
                    // PEDIR O USUARIO O TIPO EM INT
                    int tipo = 0;
                    System.out.println("Escolha o tipo de animal que deseja listar: ");
                    System.out.println("1 - Cachorro");
                    System.out.println("2 - Gato");
                    System.out.println("3 - Peixe");
                    System.out.println("4 - Pássaro");
                    System.out.println("5 - Coelho");
                    tipo = sc.nextInt();
                    sc.nextLine();

                    gerenciador.listar(tipo);
                break;

                case 0:
                    System.out.println("Obrigado por usar o sistema! Até a proxima!");
                    break;
                default:
                    System.out.printf("Opção inválida! Tente novamente.");
                    break;
            }

            System.out.printf("\n\n\n\n");
        } while (op != 0);

        sc.close();
    }
}
