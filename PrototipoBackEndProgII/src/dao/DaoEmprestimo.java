/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import model.Emprestimo;

/**
 *
 * @author gitir
 */
public class DaoEmprestimo extends Dao<Emprestimo>{
    
    @Override
    public void insert(Emprestimo emp) {
        try {
            this.beginTransaction();
            this.getEntityManager().persist(emp);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível inserir o empréstimo. Erro: " + e.getMessage());
        }
    }

    @Override
    public void update(Emprestimo emp) {
        try {
            this.beginTransaction();
            this.getEntityManager().merge(emp);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível editar o empréstimo. Erro: " + e.getMessage());
        }
    }

    @Override
    public void delete(Emprestimo emp) {
        try {
            this.beginTransaction();
            this.getEntityManager().remove(emp);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível remover o empréstimo. Erro: " + e.getMessage());
        }
    }

    @Override
    public Emprestimo list(Long id) {
        try {
            Query query = this.getEntityManager().createQuery("SELECT e from Emprestimo e where e.id = :id");
            query.setParameter("id", id);
            return (Emprestimo) query.getSingleResult();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o empréstimo de id " + id + ". Erro: " + e.getMessage());
        }
    }

    @Override
    public List<Emprestimo> listAll() {
        try {
            return this.getEntityManager().createQuery("SELECT e from Emprestimo e").getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os empréstimos. Erro: " + e.getMessage());
        }
    }
}
