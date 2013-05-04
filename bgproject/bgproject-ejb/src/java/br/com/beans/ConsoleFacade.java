/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.interfaces.ConsoleFacadeRemote;
import br.com.modelos.Console;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author 41011880
 */
@Stateless(mappedName = "ejb/ConsoleFacade")
public class ConsoleFacade extends AbstractFacade<Console> implements ConsoleFacadeRemote {

    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsoleFacade() {
        super(Console.class);
    }
}
