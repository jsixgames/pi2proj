/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import br.com.modelos.Estoque;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Calebe de Paula Bianchini
 */
@Remote
public interface EstoqueFacadeRemote {

    void create(Estoque produto);

    void edit(Estoque produto);

    void remove(Estoque produto);

    Estoque find(Object id);

    List<Estoque> findAll();

    List<Estoque> findRange(int[] range);

    int count();
    
}
