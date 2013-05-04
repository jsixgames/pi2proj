/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.modelos.Console;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ConsoleFacadeRemote {

    void create(Console console);

    void edit(Console console);

    void remove(Console console);

    Console find(Object id);

    List<Console> findAll();

    List<Console> findRange(int[] range);

    int count();
    
}
