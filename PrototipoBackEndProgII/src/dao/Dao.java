/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gitir
 * @param <T>
 */
public abstract class Dao<T> {
    private EntityManagerFactory emf;
    private EntityManager em;

    public Dao() {
        this.emf = Persistence.createEntityManagerFactory("PrototipoBackEndProgIIPU");
        this.em = emf.createEntityManager();
    }
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    protected void beginTransaction(){
        this.getEntityManager().getTransaction().begin();
    }
    
    protected void commitTransaction(){
        this.getEntityManager().getTransaction().commit();
    }
    
    public abstract void insert(T t);
    
    public abstract void update(T t);
    
    public abstract void delete(T t);
    
    public abstract T list(Long id);
    
    public abstract List<T> listAll();
}
