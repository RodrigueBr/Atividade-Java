package Services;

import Models.Bebida;
import Models.Cliente;
import Models.Doce;
import Models.Produto;
import State.Dados;

import java.util.ArrayList;

public class ProdutoService {
    public ArrayList<Produto> getProdutos() { return Dados.getProdutos(); }

    public void inserir(Produto produto) {
        Dados.getProdutos().add(produto);
    }

    public Produto getProdutoPorCodBarra(String codBarra) {
        for (Produto produto: Dados.getProdutos()) {
            if (produto.getCodBarra().equals(codBarra)) {
                return produto;
            }
        }

        return null;
    }

    public void alterar(Produto produtoAlterado) throws Exception {
        Produto produto = getProdutoPorCodBarra(produtoAlterado.getCodBarra());

        if (produto == null)
            throw  new Exception("Não é possível alterar. Produto não encontrado(a).");

        produto.setNome(produtoAlterado.getNome());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setPreco(produtoAlterado.getPreco());
        
        if (produtoAlterado instanceof Bebida) {
        	if (produto instanceof Bebida) {
        		((Bebida) produto).setMililitros(((Bebida) produtoAlterado).getMililitros());
        	} else {
                throw new Exception("O produto encontrado não é um bebida, mas o produto alterado é.");
        	}
        }
        
        if (produtoAlterado instanceof Doce) {
            if (produto instanceof Doce) {
                ((Doce) produto).setLivreGluten(((Doce) produtoAlterado).isLivreGluten());
            } else {
                throw new Exception("O produto encontrado não é um doce, mas o produto alterado é.");
            }
        }
    }

    public void excluir(String codBarra) throws Exception {
        Produto produto = getProdutoPorCodBarra(codBarra);

        if (produto == null)
            throw  new Exception("Não é possível excluir. Produto não encontrado(a).");

        Dados.getProdutos().remove(produto);
    }
}
