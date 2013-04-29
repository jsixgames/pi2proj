package br.com.interfaces;

import br.com.modelos.CadastroEndereco;
import java.util.List;
import javax.ejb.Remote; 

@Remote
public interface CadastroEnderecoRemote {

    void salvar(CadastroEndereco endereco);

    void editar(CadastroEndereco endereco);

    void remover(CadastroEndereco endereco);

    CadastroEndereco buscar(Object id);

    List<CadastroEndereco> buscarTodos();

    List<CadastroEndereco> findRange(int[] range);

    int count();    
}