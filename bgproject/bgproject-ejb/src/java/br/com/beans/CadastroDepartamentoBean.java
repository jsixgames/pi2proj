package br.com.beans;

import br.com.interfaces.ConsoleFacadeRemote;
import br.com.modelos.Departamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(mappedName = "ejb/CadastroDepartamentoBean")
public class CadastroDepartamentoBean extends AbstractFacade<Departamento> implements ConsoleFacadeRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadastroDepartamentoBean() {
        super(Departamento.class);
    }
    
}
