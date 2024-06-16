package Models;

public class ItemVenda {
	private Produto produto;

	public ItemVenda() {}

    public ItemVenda(Produto produto) {
		super();
		this.produto = produto;
	}

	public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
    	this.produto = produto;
    }
}
