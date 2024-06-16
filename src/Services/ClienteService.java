package Services;

import Models.Cliente;
import State.Dados;

import java.util.ArrayList;

public class ClienteService {
    public ArrayList<Cliente> getClientes() { return Dados.getClientes(); }

    public void inserir(Cliente cliente) {
        Dados.getClientes().add(cliente);
    }

    public Cliente getClientePorCpf(String cpf) {
        for (Cliente usr: Dados.getClientes()) {
            if (usr.getCpf().equals(cpf)) {
                return usr;
            }
        }

        return null;
    }

    public void alterar(Cliente clienteAlterado) throws Exception {
        Cliente cliente = getClientePorCpf(clienteAlterado.getCpf());

        if (cliente == null)
            throw  new Exception("Não é possível alterar. Cliente não encontrado(a).");

        cliente.setNome(clienteAlterado.getNome());
        cliente.setTelefone(clienteAlterado.getTelefone());
    }

    public void excluir(String cpf) throws Exception {
        Cliente cliente = getClientePorCpf(cpf);

        if (cliente == null)
            throw  new Exception("Não é possível excluir. Cliente não encontrado(a).");

        Dados.getClientes().remove(cliente);
    }
}
