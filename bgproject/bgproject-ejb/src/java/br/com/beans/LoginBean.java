package br.com.beans;

import br.com.classes.Login;
import br.com.interfaces.LoginRemote;
import br.com.modelos.CadastroCliente;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@ManagedBean
@SessionScoped
@Stateless(mappedName = "ejb/LoginBean")
public class LoginBean implements LoginRemote{
    
    @PersistenceContext(unitName = "bgproject-ejbPU")
    private EntityManager em;
   
    protected EntityManager getEntityManager() {
        return em;
    }
               
    @Override
    public boolean buscarEmail(Login login) {
        boolean retorno = false;
        long cont = 0;
                Query query = em.createQuery("select count(c)"
                + " from CadastroCliente c where c.email='"+login.getEmail()+"'"
                + " and c.senha='"+login.getSenha()+"'");           
                Object result = (Object) query.getSingleResult();
                cont = (Long) result;
        if (cont == 1) {
            retorno = true;
        }
                
                 return retorno;		
			
    }    

    @Override
    public String buscarNome(Login login){
        String username = null;
    if(buscarEmail(login)==true){
        Query query = em.createQuery("select c.nome"
                + " from CadastroCliente c where c.email='"+login.getEmail()+"'"
                + " and c.senha='"+login.getSenha()+"'");           
                Object result = (Object) query.getSingleResult();
                username = (String) result;                
    }
    return username;
    }
    
    @Override
    public CadastroCliente buscarCadastro(Login login){
        CadastroCliente cadastro = null;
    if(buscarEmail(login)==true){
        Query query = em.createQuery("select c from CadastroCliente c where c.email='"+login.getEmail()+"'"
                + " and c.senha='"+login.getSenha()+"'");              
                Object result = (Object) query.getSingleResult();
                cadastro = (CadastroCliente) result;                
                em.remove(cadastro);
    }
    return cadastro;
    }
}