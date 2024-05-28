/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import model.Livro;

/**
 *
 * @author gitir
 */
public class DaoLivro extends Dao<Livro>{

    @Override
    public void insert(Livro l) {
        try {
            this.beginTransaction();
            this.getEntityManager().persist(l);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível inserir o livro. Erro: " + e.getMessage());
        }
    }

    @Override
    public void update(Livro l) {
        try {
            this.beginTransaction();
            this.getEntityManager().merge(l);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível editar o livro. Erro: " + e.getMessage());
        }
    }

    @Override
    public void delete(Livro l) {
        try {
            this.beginTransaction();
            this.getEntityManager().remove(l);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível remover o livro. Erro: " + e.getMessage());
        }
    }

    @Override
    public Livro list(Long id) {
        try {
            Query query = this.getEntityManager().createQuery("SELECT l from Livro l where l.id = :id");
            query.setParameter("id", id);
            return (Livro) query.getSingleResult();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o livro de id " + id + ". Erro: " + e.getMessage());
        }
    }

    @Override
    public List<Livro> listAll() {
        try {
            return this.getEntityManager().createQuery("SELECT l from Livro l").getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os livros. Erro: " + e.getMessage());
        }
    }
}
