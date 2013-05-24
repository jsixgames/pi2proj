/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;


import br.com.interfaces.EstoqueFacadeRemote;
import br.com.modelos.Estoque;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class EstoqueController {

    @EJB
    private EstoqueFacadeRemote produtoFacade;

    public EstoqueController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext(props);
        produtoFacade = (EstoqueFacadeRemote) ctx.lookup("ejb/CadastroEstoqueBean");
    }

    public void create(Estoque entity) {
        produtoFacade.create(entity);
    }

    public void edit(Estoque entity) {
        produtoFacade.edit(entity);
    }
    
    public void remove(Estoque entity) {
        produtoFacade.remove(entity);
    }
    
    public List<Estoque> findAll() {
        return (produtoFacade.findAll());
    }
    
        public Estoque find(Object id) {
        return (produtoFacade.find(id));
    }
}
