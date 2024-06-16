package Models;

public class Salgado extends Produto{	

	public Salgado() {}
	
//	public Salgado(String nome, String descricao, double preco) {
//        super(nome, descricao, preco);
//    }
	
	@Override
    public void exibirDetalhes() {
        System.out.println("Salgado: " + getNome() + ", Descrição: " + getDescricao() + ", Preço: " + getPreco());
    }
}
