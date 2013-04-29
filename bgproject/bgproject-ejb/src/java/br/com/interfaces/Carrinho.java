package br.com.interfaces;

import java.util.Collection;
import javax.ejb.Remote;

@Remote
public interface Carrinho {

    public String addItem(String item);

    public void removeItem(String item);

    public Collection getItems();
}