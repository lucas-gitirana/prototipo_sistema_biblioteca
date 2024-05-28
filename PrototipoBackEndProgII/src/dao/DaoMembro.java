/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import model.Membro;

/**
 *
 * @author gitir
 */
public class DaoMembro extends Dao<Membro>{
    
    @Override
    public void insert(Membro m) {
        try {
            this.beginTransaction();
            this.getEntityManager().persist(m);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível inserir o membro. Erro: " + e.getMessage());
        }
    }

    @Override
    public void update(Membro m) {
        try {
            this.beginTransaction();
            this.getEntityManager().merge(m);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível editar o membro. Erro: " + e.getMessage());
        }
    }

    @Override
    public void delete(Membro m) {
        try {
            this.beginTransaction();
            this.getEntityManager().remove(m);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível remover o membro. Erro: " + e.getMessage());
        }
    }

    @Override
    public Membro list(Long id) {
        try {
            Query query = this.getEntityManager().createQuery("SELECT m from Membro m where m.id = :id");
            query.setParameter("id", id);
            return (Membro) query.getSingleResult();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o membro de id " + id + ". Erro: " + e.getMessage());
        }
    }

    @Override
    public List<Membro> listAll() {
        try {
            return this.getEntityManager().createQuery("SELECT m from Membro m").getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os membros. Erro: " + e.getMessage());
        }
    }    
}
