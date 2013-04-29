package br.com.interfaces;

import br.com.modelos.CadastroCliente;
import br.com.modelos.Login;
import javax.ejb.Remote;

@Remote
public interface LoginRemote {        
    public boolean buscarEmail(Login login);
    public String buscarNome(Login login);
    public CadastroCliente buscarCadastro(Login login);
 
}
