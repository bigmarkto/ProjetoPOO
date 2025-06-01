package executor;

import entidades.gerenciadores.GerenciadorAnimal;
import entidades.gerenciadores.GerenciadorAtendimento;
import entidades.gerenciadores.GerenciadorCompra;
import entidades.gerenciadores.GerenciadorProdutos;
import java.util.Scanner;

public class Programa {
        /**
         * Programa principal do sistema de gerenciamento de petshop.
         * 
         * Oferece ao usuário opções de gerenciamento de registros de clientes,
         * produtos e atendimentos, alem de permitir agendar e cancelar atendimentos
         * e comprar produtos.
         * 
         * @param args argumentos da linha de comando (não usados)
         */
    public static void main(String[] args) {
        int op;
        Scanner sc = new Scanner(System.in);

        GerenciadorAnimal gerenciadorAnimal = new GerenciadorAnimal();
        gerenciadorAnimal.iniciarSistema();
        GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();
        gerenciadorProdutos.iniciarProdutos();
        GerenciadorAtendimento gerenciadorAtendimento = new GerenciadorAtendimento();
        GerenciadorCompra gerenciadorCompra = new GerenciadorCompra();        

        do {
            System.out.println("---=== SISTEMA DE PETSHOP ===---");
            System.out.println("1 - Agendar um atendimento");
            System.out.println("2 - Cancelar um atendimento");
            System.out.println("3 - Comprar um produto");
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
                    gerenciadorCompra.menuCompras();
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
