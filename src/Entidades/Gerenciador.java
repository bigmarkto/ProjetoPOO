package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador implements AnimalInterface {

    private List<Animal> listaAnimais = new ArrayList<>();

    @Override
    public void cadastrar() {
        int op;

        do {

            System.out.println("---== MENU DE CADASTRO ==---");
         
            System.out.printf("\n\n\n\n");
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
                    System.out.printf("Opção inválida! Tente novamente.");
                    break;
            }

            System.out.printf("\n\n\n\n");
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
