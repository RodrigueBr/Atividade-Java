package Models;

public class Doce extends Produto {
	private boolean livreGluten;

	public Doce() {}
	
//	public Doce(String nome, String descricao, double preco, boolean livreGluten) {
//		super(nome, descricao, preco);
//		this.livreGluten = livreGluten;
//	}

	@Override
	public void exibirDetalhes() {
		System.out.println("Doce: " + getNome() + ", Descrição: " + getDescricao() + 
                ", Preço: " + getPreco() + ", Sem Glúten: " + (livreGluten ? "Sim" : "Não"));
	}

	public boolean isLivreGluten() {
		return livreGluten;
	}

	public void setLivreGluten(boolean livreGluten) {
		this.livreGluten = livreGluten;
	}

}
