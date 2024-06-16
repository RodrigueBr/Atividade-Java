package Models;

public class Pao extends Produto {

	public Pao() {}
	
//	public Pao(String nome, String descricao, double preco) {
//		super(nome, descricao, preco);
//	}

	@Override
	public void exibirDetalhes() {
		System.out.println("Pão: " + getNome() + ", Descrição: " + getDescricao() + ", Preço: " + getPreco());
	}
}
