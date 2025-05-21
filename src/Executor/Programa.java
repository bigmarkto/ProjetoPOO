package Executor;

import java.util.Scanner;

import Entidades.GerenciadorAnimal;

public class Programa {
    public static void main(String[] args) {
        int op;
        Scanner sc = new Scanner(System.in);

        GerenciadorAnimal gerenciadorAnimal = new GerenciadorAnimal();

        do {
            System.out.println("---=== SISTEMA DE PETSHOP ===---");
            System.out.println("1 - Agendar um atendimento"); // TODO: NEEMIAS
            System.out.println("2 - Comprar um produto"); // TODO: MARCO e EMANUEL
            System.out.println("3 - Gerenciamento de registros de clientes");
            System.out.println("4 - Gerenciamento de registros de produtos"); // TODO: MARCO E EMANUEL
            System.out.println("5 - Gerenciamento de registros de atendimentos"); // TODO: NEEMIAS
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Agendar um atendimento");
                    break;
                case 2:
                    System.out.println("Comprar um produto");
                    break;
                case 3:
                    gerenciadorAnimal.menuInicializar();
                    break;
                case 4:
                    System.out.println("Gerenciamento de registros de produtos");
                    break;
                case 5:
                    System.out.println("Gerenciamento de registros de atendimentos");
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (op != 0);

        sc.close();
    }
}
