package Services;

import Models.Venda;
import State.Dados;

import java.util.ArrayList;

public class VendaService {
    public ArrayList<Venda> getVenda() { return Dados.getVendas(); }

    public void inserir(Venda venda) {
        Dados.getVendas().add(venda);
    }

    public Venda getVendaPorCodigo(String codVenda) {
        for (Venda venda: Dados.getVendas()) {
            if (venda.getCodigoVenda().equals(codVenda)) {
                return venda;
            }
        }

        return null;
    }
}
