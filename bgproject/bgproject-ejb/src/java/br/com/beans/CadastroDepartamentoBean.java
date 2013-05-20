package br.com.beans;

import br.com.interfaces.ConsoleFacadeRemote;
import br.com.modelos.Departamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


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

    @Override
    public Departamento find(Object id) {
        Query query = getEntityManager().createQuery("select nome"
                + " from Departamento where id = "+id);      
        Departamento dep = new Departamento();
        dep.setNome(query.getSingleResult().toString());
                 return dep;
    }

    @Override
    public List<Departamento> findAll() {
        Query query = getEntityManager().createQuery("select nome"
                + " from Departamento");           
                 return query.getResultList();	
    }
    
    
}
