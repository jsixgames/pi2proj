package br.com.beans;

import br.com.interfaces.CadastroClienteRemote;
import br.com.modelos.CadastroCliente;
import br.com.modelos.Login;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/CadastroClienteBean")
public class CadastroClienteBean extends AbstractBean<CadastroCliente> implements CadastroClienteRemote{
    
   @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;
   
   @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public CadastroClienteBean(){
        super(CadastroCliente.class);
    }
        
   @Override
    public CadastroCliente buscar(String email, String senha){
        CadastroCliente cadastro = null;                            
    if(email != null && senha != null){
        try{
        Query query = em.createQuery("select c"
                + " from CadastroCliente c where c.email='"+email+"'"
                + " and c.senha='"+senha+"'");           
                Object result = (Object) query.getSingleResult();
                cadastro = (CadastroCliente) result;                    
                return cadastro;
        }catch(Exception e){            
            
        }
    }
    return cadastro;
    }

    @Override
    public void remover(Login login) {
        CadastroCliente cadastro=null;
    if(login != null){
        Query query = em.createQuery("select c from CadastroCliente c where c.email='"+login.getEmail()+"'"
                + " and c.senha='"+login.getSenha()+"'");              
                Object result = (Object) query.getSingleResult();
                cadastro = (CadastroCliente) result;                
    }        
                em.remove(cadastro);
    }

}

