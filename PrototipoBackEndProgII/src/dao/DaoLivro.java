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
            throw new RuntimeException("Não foi possível carregar os livros. \nErro: " + e.getMessage());
        }
    }
    
    public List<Livro> listById(Long id){
        try {
            Query query = this.getEntityManager().createQuery("SELECT l from Livro l where l.id = :id");
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o livro de id " + id + ". \nErro: " + e.getMessage());
        }
    }
    
    public List<Livro> listByEdicao(String edicao){
        try {
            Query query = this.getEntityManager().createQuery("SELECT l from Livro l where l.edicao = :edicao");
            query.setParameter("edicao", edicao);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os livros com a edição informada. \nErro: " + e.getMessage());
        }
    }
    
    public List<Livro> listByAutor(String autor){
        try {
            Query query = this.getEntityManager().createQuery("SELECT l from Livro l where l.nomeAutor = :autor");
            query.setParameter("autor", autor);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os livros com o autor informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Livro> listByEditora(String editora){
        try {
            Query query = this.getEntityManager().createQuery("SELECT l from Livro l where l.nomeEditora = :editora");
            query.setParameter("editora", editora);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os livros com a editora informada. \nErro: " + e.getMessage());
        }
    }
    
    public List<Livro> listByNumPaginas (int numPaginas){
        try {
            Query query = this.getEntityManager().createQuery("SELECT l from Livro l where l.numeroPaginas = :numPaginas");
            query.setParameter("numPaginas", numPaginas);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os livros com o número de páginas informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Livro> listByTitulo (String titulo){
        try {
            Query query = this.getEntityManager().createQuery("SELECT l from Livro l where l.titulo = :titulo");
            query.setParameter("titulo", titulo);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os livros com o título informado. \nErro: " + e.getMessage());
        }
    }
    
    
}
