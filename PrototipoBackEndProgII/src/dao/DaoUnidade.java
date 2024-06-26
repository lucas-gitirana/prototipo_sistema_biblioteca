/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;
import model.Unidade;

/**
 *
 * @author gitir
 */
public class DaoUnidade extends Dao<Unidade>{
    
    @Override
    public void insert(Unidade u) {
        try {
            this.beginTransaction();
            this.getEntityManager().persist(u);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível inserir a unidade. Erro: " + e.getMessage());
        }
    }

    @Override
    public void update(Unidade u) {
        try {
            this.beginTransaction();
            this.getEntityManager().merge(u);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível editar a unidade. Erro: " + e.getMessage());
        }
    }

    @Override
    public void delete(Unidade u) {
        try {
            this.beginTransaction();
            this.getEntityManager().remove(u);
            this.commitTransaction();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível remover a unidade. Erro: " + e.getMessage());
        }
    }

    @Override
    public Unidade list(Long id) {
        try {
            Query query = this.getEntityManager().createQuery("SELECT u from Unidade u where u.id = :id");
            query.setParameter("id", id);
            return (Unidade) query.getSingleResult();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar a unidade de id " + id + ". Erro: " + e.getMessage());
        }
    }

    @Override
    public List<Unidade> listAll() {
        try {
            return this.getEntityManager().createQuery("SELECT u from Unidade u").getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os unidades. Erro: " + e.getMessage());
        }
    }
    
    public List<Unidade> listById(Long id){
        try {
            Query query = this.getEntityManager().createQuery("SELECT u from Unidade u where u.id = :id");
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar a unidade de id " + id + ". \nErro: " + e.getMessage());
        }
    }
    
    public List<Unidade> listByIdLivro(Long id){
        try {
            Query query = this.getEntityManager().createQuery("SELECT u from Unidade u where u.livro.id = :id");
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar a unidade de id " + id + ". \nErro: " + e.getMessage());
        }
    }
    
    public List<Unidade> listByDisponibilidade(char disponibilidade){
        try {
            Query query = this.getEntityManager().createQuery("SELECT u from Unidade u where u.disponibilidade = :disponibilidade");
            query.setParameter("disponibilidade", disponibilidade);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar as unidades com disponibilidade igual a " +disponibilidade+ ". \nErro: " + e.getMessage());
        }
    }
    
    public List<Unidade> listByDataCompra(Calendar dataCompra){
        try {
            Query query = this.getEntityManager().createQuery("SELECT u from Unidade u where u.dataCompra = :dataCompra");
            query.setParameter("dataCompra", dataCompra);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar as unidades com data de compra igual a " +dataCompra+ ". \nErro: " + e.getMessage());
        }
    }

    public List<Unidade> listByTituloLivro(String titulo) {
        try {
            Query query = this.getEntityManager().createQuery("SELECT u from Unidade u where u.livro.titulo = :titulo");
            query.setParameter("titulo", titulo);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar as unidades com o título de livro informado. \nErro: " + e.getMessage());
        }
    }
}
