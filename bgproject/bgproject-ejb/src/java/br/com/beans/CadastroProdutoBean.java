/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.interfaces.ProdutoFacadeRemote;
import br.com.modelos.Departamento;
import br.com.modelos.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Stateless(mappedName = "ejb/CadastroProdutoBean")
public class CadastroProdutoBean extends AbstractFacade<Produto> implements ProdutoFacadeRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadastroProdutoBean() {
        super(Produto.class);
    }

    @Override
    public Produto find(Object id) {
        Query query = getEntityManager().createQuery("select nomeProd"
                + " from Produto where id = "+id);      
        Produto dep = new Produto();
        dep.setNomeProd(query.getSingleResult().toString());
        
        Query query2 = getEntityManager().createQuery("select categProd"
                + " from Produto where id = "+id);      
        
        dep.setCategProd(query2.getSingleResult().toString());
        
        Query query3 = getEntityManager().createQuery("select precoProd"
                + " from Produto where id = "+id);      
        String valor = query3.getSingleResult().toString();
        dep.setPrecoProd(Double.parseDouble(valor));
                 return dep;
    }

    @Override
    public List<Produto> findAll() {
        Query query = getEntityManager().createQuery("select t"
                + " from Produto as t");
        return query.getResultList();
    }

}
