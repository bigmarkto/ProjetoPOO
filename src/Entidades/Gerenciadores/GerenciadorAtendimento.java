package Entidades.Gerenciadores;

import Entidades.Animal;
import Entidades.Atendimento;
import Entidades.Dono;
import Entidades.Interfaces.AtendimentoInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorAtendimento implements AtendimentoInterface {

    GerenciadorAnimal gerenciadorAnimal = new GerenciadorAnimal();
    private static List<Atendimento> listaAtendimentos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void agendarAtendimento() {

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

    public void cancelarAtendimento() {

        int op = 1;
        do {
            listarAtendimentos();

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

    public void listarAtendimentos() {
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

    public void buscarAtendimentoPorId() {

        int op;
        do {
            listarAtendimentos();
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

    public void menuInicializar() {
        int op;

        do {
            System.out.println("---=== MENU DE GERENCIAMENTO DE ATENDIMENTOS ===---");
            System.out.println("1 - Listar todos atendimentos");
            System.out.println("2 - Buscar atendimento por ID");
            System.out.println("0 - Voltar");
            System.out.println("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    listarAtendimentos();
                    break;
                case 2:
                    buscarAtendimentoPorId();
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
