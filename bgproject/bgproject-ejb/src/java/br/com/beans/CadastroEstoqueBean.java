/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.interfaces.EstoqueFacadeRemote;
import br.com.modelos.Estoque;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateless(mappedName = "ejb/CadastroEstoqueBean")
public class CadastroEstoqueBean extends AbstractFacade<Estoque> implements EstoqueFacadeRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void create(Estoque entity) {
        getEntityManager().persist(entity);
    }

    public CadastroEstoqueBean() {
        super(Estoque.class);
    }

    @Override
    public Estoque find(Object id) {
        Query query = getEntityManager().createQuery("select nomeProd"
                + " from Estoque where id = "+id);      
        Estoque dep = new Estoque();
        dep.setNomeProd(query.getSingleResult().toString());
        
        Query query2 = getEntityManager().createQuery("select categProd"
                + " from Estoque where id = "+id);      
        
        dep.setCategProd(query2.getSingleResult().toString());
        
        Query query3 = getEntityManager().createQuery("select precoProd"
                + " from Estoque where id = "+id);      
        String valor = query3.getSingleResult().toString();
        dep.setPrecoProd(Double.parseDouble(valor));
                 return dep;
    }

    @Override
    public List<Estoque> findAll() {
        Query query = getEntityManager().createQuery("select t"
                + " from banco.Estoque as t");
        List<Estoque> listaProd = query.getResultList();
        return listaProd;
    }

}
