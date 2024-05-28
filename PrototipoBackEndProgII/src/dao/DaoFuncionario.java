/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import model.Funcionario;

/**
 *
 * @author gitir
 */
public class DaoFuncionario extends Dao<Funcionario>{

    @Override
    public void insert(Funcionario f) {
        try {
            this.beginTransaction();
            this.getEntityManager().persist(f);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível inserir o funcionário. Erro: " + e.getMessage());
        }
    }

    @Override
    public void update(Funcionario f) {
        try {
            this.beginTransaction();
            this.getEntityManager().merge(f);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível editar o funcionário. Erro: " + e.getMessage());
        }
    }

    @Override
    public void delete(Funcionario f) {
        try {
            this.beginTransaction();
            this.getEntityManager().remove(f);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível remover o funcionário. Erro: " + e.getMessage());
        }
    }

    @Override
    public Funcionario list(Long id) {
        try {
            Query query = this.getEntityManager().createQuery("SELECT f from Funcionario f where f.id = :id");
            query.setParameter("id", id);
            return (Funcionario) query.getSingleResult();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o funcionário de id " + id + ". Erro: " + e.getMessage());
        }
    }

    @Override
    public List<Funcionario> listAll() {
        try {
            return this.getEntityManager().createQuery("SELECT f from Funcionario f").getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os funcionários. Erro: " + e.getMessage());
        }
    }    
}
