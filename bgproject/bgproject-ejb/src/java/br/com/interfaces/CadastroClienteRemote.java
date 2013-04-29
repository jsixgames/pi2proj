package br.com.interfaces;

import br.com.modelos.CadastroCliente;
import br.com.modelos.Login;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CadastroClienteRemote {

    void salvar(CadastroCliente cliente);

    void editar(CadastroCliente cliente);

    public void remover(Login cliente);

    public CadastroCliente buscar(Login login);

    List<CadastroCliente> buscarTodos();

    List<CadastroCliente> findRange(int[] range);

    int count();    
}