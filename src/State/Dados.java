package State;

import Models.*;

import java.util.ArrayList;

public class Dados {
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static ArrayList<Produto> produtos = new ArrayList<Produto>();
    private static ArrayList<Venda> vendas = new ArrayList<Venda>();

    private static Usuario usuarioLogado = null;
	
    public static ArrayList<Usuario> getUsuarios() {
        if (usuarios.isEmpty()) {
            Administrador adm = new Administrador();
            adm.setNome("Admin");
            adm.setEmail("admin@email.com");
            adm.setSenha("@dmin123");
            usuarios.add(adm);
            padraoUsuarios();
        }

        return usuarios;
    }
    
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public static ArrayList<Produto> getProdutos() {
    	if (produtos.isEmpty()) {
    		padraoProdutos();
    	}
        return produtos;
    }
    
    public static ArrayList<Venda> getVendas() {
        return vendas;
    }

    public static void padraoUsuarios() {
        Administrador adm = new Administrador();
        adm.setNome("Admin");
        adm.setEmail("admin2@email.com");
        adm.setSenha("admin123");
        adm.setPrimeiroLogin(false);
        usuarios.add(adm);

        Padeiro padeiro = new Padeiro();
        padeiro.setNome("Padeiro 1");
        padeiro.setEmail("padeiro@email.com");
        padeiro.setSenha("padeiro123");
        padeiro.setTelefone("(42) 92345-7890");
        padeiro.setPrimeiroLogin(false);
        usuarios.add(padeiro);

        Atendente atendente = new Atendente();
        atendente.setNome("Atendente 1");
        atendente.setEmail("atendente@email.com");
        atendente.setSenha("atendente123");
        atendente.setTelefone("(42) 99999-7890");
        atendente.setPrimeiroLogin(false);
        usuarios.add(atendente);

        Cliente cliente = new Cliente();
        cliente.setNome("Cliente 1");
        cliente.setCpf("123.456.789-99");
        cliente.setTelefone("(42) 98888-8888");
        clientes.add(cliente);
    }
    
    public static void padraoProdutos() {
        Bebida bebida = new Bebida();
        bebida.setCodBarra("000111222");
        bebida.setNome("Refrigerante");
        bebida.setDescricao("Refrigerante de 300ml");
        bebida.setPreco(5);
        bebida.setMililitros(300);
        produtos.add(bebida);

        Doce doce = new Doce();
        doce.setCodBarra("333444555");
        doce.setNome("Doce 1");
        doce.setDescricao("Doce 1 descricao");
        doce.setPreco(2);
        doce.setLivreGluten(false);
        produtos.add(doce);

        Pao pao = new Pao();
        pao.setCodBarra("222333444");
        pao.setNome("Pão Frances");
        pao.setDescricao("Pão frances");
        pao.setPreco(10);
        produtos.add(pao);

        Salgado salgado = new Salgado();
        salgado.setCodBarra("111222333");
        salgado.setNome("Salgado 1");
        salgado.setDescricao("Salgado descricao");
        salgado.setPreco(6);
        produtos.add(salgado);
    }

    

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        Dados.usuarioLogado = usuarioLogado;
    }
}
