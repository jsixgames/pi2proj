package br.com.beans;

import br.com.interfaces.CarrinhoRemote;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful(mappedName="ejb/Cart")
public class CarrinhoBean implements CarrinhoRemote {

    private ArrayList<String> items;

    @PostConstruct
    public void initialize() {
        items = new ArrayList();
    }

    @Override
    public String addItem(String item) {
        items.add(item);
        System.out.println("Received request for buy " + item);
        return "Item " + item + " added succesfully!";
    }

    @Override
    public void removeItem(String item) {
        items.remove(item);       
    }

    @Override
    public Collection getItems() {        
        return items;
    }
    
    @Override
    public int qtde(){        
        return items.size();
    }
}
