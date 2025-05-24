package Executor;

import Entidades.Gerenciadores.GerenciadorAnimal;
import Entidades.Gerenciadores.GerenciadorAtendimento;
import Entidades.Gerenciadores.GerenciadorProdutos;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        int op;
        Scanner sc = new Scanner(System.in);

        GerenciadorAnimal gerenciadorAnimal = new GerenciadorAnimal();
        gerenciadorAnimal.iniciarSistema();
        GerenciadorAtendimento gerenciadorAtendimento = new GerenciadorAtendimento();
        GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();
        

        do {
            System.out.println("---=== SISTEMA DE PETSHOP ===---");
            System.out.println("1 - Agendar um atendimento");
            System.out.println("2 - Cancelar um atendimento");
            System.out.println("3 - Comprar um produto"); // TODO: MARCO e EMANUEL
            System.out.println("4 - Gerenciamento de registros de clientes");
            System.out.println("5 - Gerenciamento de registros de produtos");
            System.out.println("6 - Gerenciamento de registros de atendimentos"); 
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    gerenciadorAtendimento.agendarAtendimento();
                    break;
                case 2:
                    gerenciadorAtendimento.cancelarAtendimento();
                    break;
                case 3:
                    
                    break;
                case 4:
                    gerenciadorAnimal.menuInicializar();
                    break;
                case 5:
                    gerenciadorProdutos.menuProdutos();
                    break;
                case 6:
                     gerenciadorAtendimento.menuInicializar();
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
