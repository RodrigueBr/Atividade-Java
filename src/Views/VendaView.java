package Views;

import Models.*;
import Services.ProdutoService;
import Services.VendaService;

import java.util.Scanner;

public class VendaView {
    public static void apresentarMenu() {
        System.out.println("Menu de vendas (escolha uma opção):");
        System.out.println(" 1 - Listar");
        System.out.println(" 2 - Inserir");
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
                default:
                    continuar = true;
            }
        } while (continuar);
    }

    private static void listar() {
        VendaService servico = new VendaService();

        System.out.println("\nLista de Vendas do Sistema:");

        for (Venda venda: servico.getVenda()) {
            venda.exibirDetalhes();
        }

        System.out.println("-----------------------------\n");
    }

    private static void inserir() {
        Scanner sc = new Scanner(System.in);
        
    	VendaService servico = new VendaService();
        ProdutoService produtoServico = new ProdutoService();

        System.out.println("\nInserindo Venda:");
        
        System.out.print("  Código da Venda: ");
        String codigoVenda = sc.nextLine();
        
        Venda venda = new Venda();
        venda.setCodigoVenda(codigoVenda);

        boolean adicionarMaisProdutos = true;

        while (adicionarMaisProdutos) {
            System.out.print("  Código de Barra do Produto: ");
            String codBarra = sc.nextLine();
            Produto produto = produtoServico.getProdutoPorCodBarra(codBarra);

            if (produto == null) {
                System.out.println("  Produto não encontrado");
                continue;
            }

            venda.adicionarProduto(produto);

            System.out.print("  Deseja adicionar mais produtos? (1 para Sim, 0 para Não): ");
            int resposta = sc.nextInt();
            sc.nextLine();
            adicionarMaisProdutos = (resposta == 1);
        }

        servico.inserir(venda);
    }
}
