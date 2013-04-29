package br.com.beans;

import br.com.modelos.CadastroEndereco;
import br.com.interfaces.CadastroEnderecoRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/CadastroEnderecoBean")
public class CadastroEnderecoBean extends AbstractBean<CadastroEndereco> implements CadastroEnderecoRemote{
    
    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadastroEnderecoBean() {
        super(CadastroEndereco.class);
    }
}

