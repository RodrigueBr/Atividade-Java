package Views;

import Models.*;
import Services.ClienteService;

import java.util.Scanner;

public class ClienteView {
    public static void apresentarMenu() {
        System.out.println("Menu de clientes (escolha uma opção):");
        System.out.println(" 1 - Listar");
        System.out.println(" 2 - Inserir");
        System.out.println(" 3 - Alterar");
        System.out.println(" 4 - Excluir");
        System.out.print("Opção: ");

        boolean continuar;

        do {
            continuar = false;

            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    listar();
                    break;
                case 2:
                    inserir();
                    break;
                case 3:
                    alterar();
                    break;
                case 4:
                    excluir();
                    break;
                default:
                    continuar = true;
            }
        } while (continuar);
    }

    private static void listar() {
        ClienteService servico = new ClienteService();

        System.out.println("\nLista de Clientes do Sistema:");

        for (Cliente usr: servico.getClientes()) {
            System.out.printf("%s - %s - %s\n", usr.getNome(), usr.getCpf(), usr.getTelefone());
        }

        System.out.println("-----------------------------\n");
    }

    private static void inserir() {
        System.out.println("\nInserindo Cliente:");
        Cliente cliente = new Cliente();
        lerCliente(cliente);
        ClienteService servico = new ClienteService();
        servico.inserir(cliente);
    }

    private static void lerCliente(Cliente cliente) {
        Scanner sc = new Scanner(System.in);

        System.out.print("  Nome: ");
        cliente.setNome(sc.nextLine());
        System.out.print("  CPF: ");
        cliente.setCpf(sc.nextLine());
        System.out.print("  Telefone: ");
        cliente.setTelefone(sc.nextLine());
    }

    private static void alterar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("CPF do(a) cliente a ser alterado(a): ");
        String cpf = sc.nextLine();
        ClienteService servico = new ClienteService();

        Cliente cliente = servico.getClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Usuário não encontrado");
            return;
        }

        System.out.print("  Nome: ");
        cliente.setNome(sc.nextLine());
        System.out.print("  Telefone: ");
        cliente.setTelefone(sc.nextLine());

        try {
            servico.alterar(cliente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void excluir() {
        Scanner sc = new Scanner(System.in);

        System.out.print("CPF do(a) cliente a ser excluído(a): ");
        String cpf = sc.nextLine();
        
        ClienteService servico = new ClienteService();

        Cliente cliente = servico.getClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado");
            return;
        }

        try {
            servico.excluir(cliente.getCpf());
            System.out.println("Cliente excluído(a) com sucesso!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
