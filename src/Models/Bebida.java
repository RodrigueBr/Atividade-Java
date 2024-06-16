package Models;

public class Bebida extends Produto {
	private int mililitros;
	
	public Bebida() {}
	
//	public Bebida(String nome, String descricao, double preco, int mililitros) {
//		super(nome, descricao, preco);
//		this.mililitros = mililitros;
//	}
	
	@Override
    public void exibirDetalhes() {
        System.out.println("Bebida: " + getNome() + ", Descrição: " + getDescricao() +  ", Preço: " + getPreco() + ", Quantidade: " + mililitros + "ml");
    }

	public int getMililitros() {
		return mililitros;
	}

	public void setMililitros(int mililitros) {
		this.mililitros = mililitros;
	}

}
