/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Calendar;
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
    
    public List<Membro> listById(Long id){
        try {
            Query query = this.getEntityManager().createQuery("SELECT m from Membro m where m.id = :id");
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o membro de id " + id + ". \nErro: " + e.getMessage());
        }
    }
    
    public List<Membro> listByCpf(String cpf){
        try {
            Query query = this.getEntityManager().createQuery("SELECT m from Membro m where m.cpf = :cpf");
            query.setParameter("cpf", cpf);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o membro com o CPF informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Membro> listByNome(String nome){
        try {
            Query query = this.getEntityManager().createQuery("SELECT m from Membro m where m.nome = :nome");
            query.setParameter("nome", nome);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o membro com o nome informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Membro> listByDataNascimento (Calendar dataNascimento){
        try {
            Query query = this.getEntityManager().createQuery("SELECT m from Membro m where m.dataNascimento = :dataNascimento");
            query.setParameter("dataNascimento", dataNascimento);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os membros com a data de nascimento informada. \nErro: " + e.getMessage());
        }
    }
    
    public List<Membro> listByDataCadastro (Calendar dataCadastro){
        try {
            Query query = this.getEntityManager().createQuery("SELECT m from Membro m where m.dataCadastro = :dataCadastro");
            query.setParameter("dataCadastro", dataCadastro);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os funcionários com a data de cadastro informada. \nErro: " + e.getMessage());
        }
    }
    
    public List<Membro> listByPlano(char plano){
        try {
            Query query = this.getEntityManager().createQuery("SELECT m from Membro m where m.plano = :plano");
            query.setParameter("plano", plano);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os funcionários com o cargo informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Membro> listByStatus(char status){
        try {
            Query query = this.getEntityManager().createQuery("SELECT m from Membro m where m.status = :status");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os funcionários com o status informado. \nErro: " + e.getMessage());
        }
    }        
}
