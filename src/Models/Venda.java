package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
	private String codigoVenda;
    private Date dataVenda;
    private List<ItemVenda> itensVendidos;
    private double valorTotal;

    public Venda() {
    	this.itensVendidos = new ArrayList<ItemVenda>();
    	this.dataVenda = new Date();
    }

    public void adicionarProduto(Produto produto) {
        ItemVenda itemVenda = new ItemVenda(produto);
        itensVendidos.add(itemVenda);
        calcularValorTotal();
    }

    public void removerProduto(Produto produto) {
        itensVendidos.removeIf(item -> item.getProduto().equals(produto));
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        valorTotal = 0.0;
        for (ItemVenda item : itensVendidos) {
            valorTotal += item.getProduto().getPreco();
        }
    }

    public void exibirDetalhes() {
        System.out.println("Código da Venda: " + codigoVenda);
        System.out.println("Data da Venda: " + dataVenda);
        System.out.println("Itens Vendidos:");
        for (ItemVenda item : itensVendidos) {
            System.out.printf("Produto: %s, Preço Unitário: %.2f\n", 
                item.getProduto().getNome(), item.getProduto().getPreco());
        }
        System.out.printf("Valor Total da Venda: %.2f\n", valorTotal);
    }

	public String getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(String codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public List<ItemVenda> getItensVendidos() {
		return itensVendidos;
	}

	public void setItensVendidos(List<ItemVenda> itensVendidos) {
		this.itensVendidos = itensVendidos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
