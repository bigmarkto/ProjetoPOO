package entidades.gerenciadores;

import entidades.Animal;
import entidades.classes_animais.*;
import entidades.Atendimento;
import entidades.Dono;
import entidades.interfaces.Interface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorAtendimento implements Interface {

    GerenciadorAnimal gerenciadorAnimal = new GerenciadorAnimal();
    private static List<Atendimento> listaAtendimentos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    /**
     * Agenda um atendimento para um animal.
     *
     * O metodo pergunta ao usuario o ID do atendimento, o nome do cliente, o
     * nome do animal, a data e hora do atendimento e o servico. Em seguida,
     * verifica se o ID ja esta cadastrado. Se sim, exibe uma mensagem de erro e
     * volta a pedir os dados. Se nao, cadastra o atendimento na lista de
     * atendimentos.
     *
     * O metodo tambem verifica se o animal existe e se o dono do animal eh o
     * mesmo que o cliente que esta agendando o atendimento.
     *
     * O loop eh interrompido quando o usuario escolhe a opcao de sair.
     */

     public void iniciarSistema() {
        listaAtendimentos.add(new Atendimento(1, new Dono("João"), new Cachorro("Rex", 10, new Dono("João")), "2023-10-01 10:00", "Vacinação"));
        listaAtendimentos.add(new Atendimento(2, new Dono("Maria"), new Coelho("Bobby", 5, new Dono("Maria")), "2023-10-02 11:00", "Consulta"));
     }

    @Override
    public void cadastrar() {

        int op = 1;
        do {

            System.out.println("Digite o ID do atendimento: ");
            int id = sc.nextInt();
            sc.nextLine();
            if (id <= 0) {
                System.out.println("ID inválido. Tente novamente.");
                continue;
            }

            if (!(listaAtendimentos.isEmpty())) {
                int encontrou = 0;
                for (Atendimento atendimento : listaAtendimentos) {
                    if (atendimento.getId() == id) {

                        System.out.println("ID já cadastrado. Tente novamente.");
                        encontrou = 1;
                        break;
                    }
                }
                if (encontrou == 1) {
                    continue;
                }
            }

            System.out.println("Digite o nome do cliente: ");
            String cliente = sc.nextLine();

            System.out.println("Digite o nome do animal: ");
            String animal = sc.nextLine();

            System.out.println("Digite a data e hora do atendimento: ");
            String dataHora = sc.nextLine();

            System.out.println("Digite o serviço: ");
            String servico = sc.nextLine();

            Animal animalObj = gerenciadorAnimal.getAnimalByNameAndDono(animal, cliente);
            if (animalObj == null) {
                System.out.println("Animal não encontrado.");
                return;
            }

            Dono dono = animalObj.getDono();
            Atendimento atendimento = new Atendimento(id, dono, animalObj, dataHora, servico);
            listaAtendimentos.add(atendimento);

            System.out.println("Atendimento agendado com sucesso!");

            System.out.println("Deseja agendar outro atendimento? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
            sc.nextLine();
        } while (op != 0);
    }

    /**
     * Cancela um atendimento.
     *
     * O metodo pergunta ao usuario o ID do atendimento que deseja cancelar.
     * Após, busca o atendimento na lista de atendimentos e o remove se
     * encontrado. Se nao encontrado, exibe uma mensagem de erro.
     *
     * O loop eh interrompido quando o usuario escolhe a opcao de sair.
     */
    @Override
    public void remover() {

        int op = 1;
        do {
            listar();

            if (listaAtendimentos.isEmpty()) {
                return;
            }

            System.out.println("Digite o ID do atendimento que deseja cancelar: ");
            int id = sc.nextInt();
            sc.nextLine();

            // Busca o atendimento pelo ID
            Atendimento atendimentoParaCancelar = null;
            for (Atendimento atendimento : listaAtendimentos) {
                if (atendimento.getId() == id) {
                    atendimentoParaCancelar = atendimento;
                    break;
                }
            }

            // Cancela o atendimento se encontrado
            if (atendimentoParaCancelar != null) {
                listaAtendimentos.remove(atendimentoParaCancelar);
                System.out.println("Atendimento cancelado com sucesso!");
            } else {
                System.out.println("Atendimento não encontrado.");
            }

            System.out.println("Deseja cancelar outro atendimento? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
            sc.nextLine();
        } while (op != 0);
    }

    /**
     * Exibe todos os atendimentos agendados.
     *
     * Verifica se a lista de atendimentos está vazia. Se estiver vazia, exibe
     * uma mensagem e sai do método.
     *
     * Caso contrário, exibe todos os atendimentos agendados em uma lista,
     * mostrando o ID, o nome do cliente, o nome do animal, a data e hora e o
     * serviço de cada atendimento.
     */
    @Override
    public void listar() {
        // Verifica se a lista de atendimentos está vazia
        if (listaAtendimentos.isEmpty()) {
            System.out.println("Nenhum atendimento agendado.");
            return;
        }

        // Exibe os atendimentos agendados
        System.out.println("---=== LISTA DE ATENDIMENTOS AGENDADOS ===---");
        for (Atendimento atendimento : listaAtendimentos) {
            // Exibe os detalhes na forma tabular
            System.out.printf("ID: %d | Cliente: %s | Animal: %s | Data e Hora: %s | Serviço: %s%n",
                    atendimento.getId(),
                    atendimento.getCliente().getNome(),
                    atendimento.getAnimal().getNome(),
                    atendimento.getDataHora(),
                    atendimento.getServico());
        }
    }

    public void listar(int tipo) {
        // TODO MARCO

    }

    public void alterar() {
        // TODO MARCO
        int op = 1;
        do{
        System.out.println("---== ALTERAR ATENDIMENTO ===---");
        System.out.print("Digite o ID do atendimento que deseja alterar: ");
        int id = sc.nextInt();
        sc.nextLine();

        
        Atendimento atendimentoParaAlterar = null;
        for (Atendimento atendimento : listaAtendimentos) {
            if (atendimento.getId() == id) {
                atendimentoParaAlterar = atendimento;
                break;
            }
        }

        if (atendimentoParaAlterar != null) {
            System.out.println("Atendimento encontrado:");
            System.out.printf("ID: %d | Cliente: %s | Animal: %s | Data e Hora: %s | Serviço: %s%n",
                    atendimentoParaAlterar.getId(),
                    atendimentoParaAlterar.getCliente().getNome(),
                    atendimentoParaAlterar.getAnimal().getNome(),
                    atendimentoParaAlterar.getDataHora(),
                    atendimentoParaAlterar.getServico());

            System.out.println("Escolha o campo que deseja alterar:");
            System.out.println("1 - Nome do cliente");
            System.out.println("2 - Nome do animal");
            System.out.println("3 - Data e hora");
            System.out.println("4 - Serviço");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o novo nome do cliente: ");
                    String novoNomeCliente = sc.nextLine();
                    atendimentoParaAlterar.getCliente().setNome(novoNomeCliente);
                    break;
                case 2:
                    System.out.print("Digite o novo nome do animal: ");
                    String novoNomeAnimal = sc.nextLine();
                    atendimentoParaAlterar.getAnimal().setNome(novoNomeAnimal);
                    break;
                case 3:
                    System.out.print("Digite a nova data e hora: ");
                    String novaDataHora = sc.nextLine();
                    atendimentoParaAlterar.setDataHora(novaDataHora);
                    break;
                case 4:
                    System.out.print("Digite o novo serviço: ");
                    String novoServico = sc.nextLine();
                    atendimentoParaAlterar.setServico(novoServico);
                    break;
            }

            System.out.println("Alterações salvas com sucesso!");
        } else {
            System.out.println("Atendimento não encontrado.");
        }

        System.out.println("Deseja alterar outro atendimento? \n 1 - Sim \n 0 - Não");
        op = sc.nextInt();
        sc.nextLine();
            
        }while(op != 0);
        
    }

    
    /**
     * Busca um atendimento pelo ID.
     *
     * Exibe todos os atendimentos agendados e pede ao usuário digitar o ID do
     * atendimento que deseja buscar.
     *
     * Se o atendimento for encontrado, exibe os detalhes do atendimento. Caso
     * contrário, exibe uma mensagem de erro.
     *
     * O loop é interrompido quando o usuário escolhe a opção de sair.
     */

     @Override
    public void buscar() {

        int op;
        do {
            listar();
            System.out.println("Digite o ID do atendimento que deseja buscar: ");
            int id = sc.nextInt();
            sc.nextLine();

            // Busca o atendimento pelo ID
            Atendimento atendimentoEncontrado = null;
            for (Atendimento atendimento : listaAtendimentos) {
                if (atendimento.getId() == id) {
                    atendimentoEncontrado = atendimento;
                    break;
                }
            }
            // Exibe os detalhes do atendimento encontrado
            if (atendimentoEncontrado != null) {
                System.out.printf("ID: %d | Cliente: %s | Animal: %s | Data e Hora: %s | Serviço: %s%n",
                        atendimentoEncontrado.getId(),
                        atendimentoEncontrado.getCliente().getNome(),
                        atendimentoEncontrado.getAnimal().getNome(),
                        atendimentoEncontrado.getDataHora(),
                        atendimentoEncontrado.getServico());
            } else {
                System.out.println("Atendimento não encontrado.");
            }

            System.out.println("Deseja buscar outro atendimento? \n 1 - Sim \n 0 - Não");
            op = sc.nextInt();
            sc.nextLine();
        } while (op != 0);
    }

    /**
     * Exibe o menu de gerenciamento de atendimentos.
     *
     * O menu oferece opções para listar todos os atendimentos ou buscar um
     * atendimento específico pelo ID. O usuário pode escolher uma opção
     * digitando o número correspondente.
     *
     * Se a opção digitada for inválida, o sistema exibe uma mensagem de erro e
     * volta a exibir o menu. Caso contrário, o sistema executa a opção
     * escolhida e volta a exibir o menu.
     *
     * O loop só é interrompido quando o usuário escolhe a opção de voltar.
     */
    @Override
    public void menu() {
        int op;

        do {
            System.out.println("---=== MENU DE GERENCIAMENTO DE ATENDIMENTOS ===---");
            System.out.println("1 - Listar todos atendimentos");
            System.out.println("2 - Buscar atendimento por ID");
            System.out.println("3 - Cancelar atendimento");
            System.out.println("4 - Alterar atendimento");
            System.out.println("0 - Voltar");
            System.out.println("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    listar();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    remover();
                    break;
                case 4:
                    alterar();
                    break;
                case 0:
                    System.out.println("Voltando....");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (op != 0);
    }

}
