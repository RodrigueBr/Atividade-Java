package Views;

import Models.Administrador;
import Models.Padeiro;
import Models.Atendente;
import Models.Usuario;
import Services.UsuarioService;

import java.util.Scanner;

public class SistemaView {
    public static void iniciar() {
        UsuarioService servico = new UsuarioService();
        Usuario usuarioLogado;

        boolean continuar;

        do {
            usuarioLogado = servico.getUsuarioLogado();

            if (usuarioLogado == null) {
                UsuarioView.login();
            }

            usuarioLogado = servico.getUsuarioLogado();

            if (usuarioLogado != null) {
                continuar = apresentarMenu(usuarioLogado);
            } else {
                continuar = true;
            }
        } while (continuar);
    }

    private static boolean apresentarMenu(Usuario usuarioLogado) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Olá %s!\n", usuarioLogado.getNome());
        System.out.println("Menu (escolha a opção desejada):");
        System.out.println(" 0 - Sair");
        System.out.println(" 1 - Logout");

        if (usuarioLogado instanceof Atendente) {
            System.out.println(" 2 - Clientes");
            System.out.println(" 3 - Produtos");
            System.out.println(" 4 - Vender");
        }

        if (usuarioLogado instanceof Padeiro) {
            System.out.println(" 3 - Produtos");
        }

        if (usuarioLogado instanceof Administrador) {
            System.out.println(" 2 - Clientes");
            System.out.println(" 3 - Produtos");
            System.out.println(" 4 - Vender");
            System.out.println(" 5 - Usuários");
        }

        System.out.print(" Opção: ");
        int opcao = sc.nextInt();

        while (true) {
            switch (opcao) {
                case 0:
                    return false;
                case 1:
                    UsuarioService servico = new UsuarioService();
                    servico.logout();
                    return true;
                case 2:
                    ClienteView.apresentarMenu();
                    return true;
                case 3:
                    ProdutoView.apresentarMenu();
                    return true;
                case 4:
                    VendaView.apresentarMenu();
                    return true;
                case 5:
                    UsuarioView.apresentarMenu();
                    return true;
                default:
                    System.out.println(" Opção inválida!");
            }
        }
    }
}
