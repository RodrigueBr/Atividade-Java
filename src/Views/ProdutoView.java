package Views;

import Models.*;
import Services.ProdutoService;
import Services.UsuarioService;

import java.util.Scanner;

public class ProdutoView {
    public static void apresentarMenu() {
        System.out.println("Menu de produtos (escolha uma opção):");
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
        ProdutoService servico = new ProdutoService();

        System.out.println("\nLista de Produtos do Sistema:");

        for (Produto produto : servico.getProdutos()) {
            System.out.printf("%s - %s - %s - %.2f\n", produto.getCodBarra(), produto.getNome(), produto.getDescricao(), produto.getPreco());
        }

        System.out.println("-----------------------------\n");
    }

    private static void inserir() {
        System.out.println("\nInserindo Produto:");
        Produto produto = lerComBaseEmTipo();
        ProdutoService servico = new ProdutoService();
        servico.inserir(produto);
    }
    
    private static Produto lerComBaseEmTipo() {
        int tipo;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Tipo de usuário (1 - Bebida, 2 - Doce, 3 - Pao, 4 - Salgado: ");
            tipo = sc.nextInt();

            switch (tipo) {
                case 1:
                    Bebida bebida = new Bebida();
                    lerProduto(bebida);
                    lerBebida(bebida);
                    return bebida;
                case 2:
                    Doce doce = new Doce();
                    lerProduto(doce);
                    lerDoce(doce);
                    return doce;
                case 3:
                    Pao pao = new Pao();
                    lerProduto(pao);
                    return pao;
                case 4:
                    Salgado salgado = new Salgado();
                    lerProduto(salgado);
                    return salgado;
                default:
                    System.out.println("Tipo de produto inválido!");
            }
        }
    }
    
    private static void lerBebida(Bebida bebida) {
        Scanner sc = new Scanner(System.in);

        System.out.print("  Quantidade (ml): ");
        bebida.setMililitros(sc.nextInt());
    }
    
    private static void lerDoce(Doce doce) {
        Scanner sc = new Scanner(System.in);

        System.out.print("  Livre de Gluten? (1 para Sim, 0 para Não): ");
        int resposta = sc.nextInt();
        boolean livreGluten = (resposta == 1);

        doce.setLivreGluten(livreGluten);
    }

    private static void lerProduto(Produto produto) {
        Scanner sc = new Scanner(System.in);

        System.out.print("  Codigo de Barra: ");
        produto.setCodBarra(sc.nextLine());
        System.out.print("  Nome: ");
        produto.setNome(sc.nextLine());
        System.out.print("  Descrição: ");
        produto.setDescricao(sc.nextLine());
        System.out.print("  Preço: ");
        produto.setPreco(sc.nextDouble());
    }

    private static void alterar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Codigo de barra do produto a ser alterado: ");
        String codBarra = sc.nextLine();
        ProdutoService servico = new ProdutoService();

        Produto produto = servico.getProdutoPorCodBarra(codBarra);

        if (produto == null) {
            System.out.println("Produto não encontrado");
            return;
        }


        System.out.print("  Nome: ");
        produto.setNome(sc.nextLine());
        System.out.print("  Descrição: ");
        produto.setDescricao(sc.nextLine());
        System.out.print("  Preço: ");
        produto.setPreco(sc.nextDouble());
        
        if (produto instanceof Bebida) {
            lerBebida((Bebida) produto);
        } else if (produto instanceof Doce) {
            lerDoce((Doce) produto);
        }
        
    }

    private static void excluir() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Codigo de barras do produto a ser excluído: ");
        String codBarras = sc.nextLine();
        
        ProdutoService servico = new ProdutoService();

        Produto produto = servico.getProdutoPorCodBarra(codBarras);

        if (produto == null) {
            System.out.println("Produto não encontrado");
            return;
        }

        try {
            servico.excluir(produto.getCodBarra());
            System.out.println("Produto excluído(a) com sucesso!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
