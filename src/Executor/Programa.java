package Executor;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        // Váriaveis iniciais
        int op;

        // Menu de opções
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("---== MENU DE OPÇÕES ==---");
            System.out.println("1 - Cadastrar animal no sistema");
            System.out.println("2 - Alterar informações do animal");
            System.out.println("3 - Remover animal do sistema");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Você escolheu a opção 1");
                    break;
                case 2:
                    System.out.println("Você escolheu a opção 2");
                    break;
                case 3:
                    System.out.println("Você escolheu a opção 3");
                    break;
                case 0:
                    System.out.println("Obrigado por usar o sistema! Até a proxima!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (op != 0);

        sc.close();
    }
}
