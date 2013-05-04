/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo.controller;

import br.com.interfaces.ConsoleFacadeRemote;
import br.com.modelos.Console;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ConsoleController {
     
    @EJB 
    private ConsoleFacadeRemote consoleFacade;

    public ConsoleController() throws Exception {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream("jndi.properties"));
        InitialContext ctx = new InitialContext();
        consoleFacade = (ConsoleFacadeRemote) ctx.lookup("ejb/ConsoleFacade");
    }

    public void create(Console entity) {
        consoleFacade.create(entity);
    }

    public void edit(Console entity) {
        consoleFacade.edit(entity);
    }
    
    public void remove(Console entity) {
        consoleFacade.remove(entity);
    }
    
    public List<Console> findAll() {
        return (consoleFacade.findAll());
    }
    
    
}
