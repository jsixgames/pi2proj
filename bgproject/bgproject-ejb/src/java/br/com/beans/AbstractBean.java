package br.com.beans;

import java.util.List;
import javax.persistence.EntityManager;


public abstract class AbstractBean<T> {
    private Class<T> entityClass;
    
    
    public AbstractBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager entityManager;
    protected abstract EntityManager getEntityManager();
    
                    
    public void salvar(T entity) {        
        getEntityManager().persist(entity);
    }

    public void editar(T entity) {
        getEntityManager().merge(entity);
    }

    public void remover(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T buscar(Object id) {       
        return getEntityManager().find(entityClass, id);
    }

    public List<T> buscarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();  
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }    
}
