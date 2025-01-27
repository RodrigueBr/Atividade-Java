package Models;

public abstract class Produto {
	private String nome;
	private String descricao;
	private String codBarra;
	private double preco;
	
	public Produto() {}
	
//	public Produto(String nome, String descricao, double preco) {
//		super();
//		this.nome = nome;
//		this.descricao = descricao;
//		this.preco = preco;
//	}
	
	public abstract void exibirDetalhes();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}

}
