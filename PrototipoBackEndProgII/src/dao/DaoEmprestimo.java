/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;
import model.Emprestimo;
import model.Unidade;

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
    
    public List<Unidade> listUnidades(Long id){
        try {
            Query query = this.getEntityManager().createQuery("SELECT e.unidades from Emprestimo e where e.id = :id");
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os empréstimos. Erro: " + e.getMessage());
        }
    }
    
    public List<Emprestimo> listById(Long id){
        try {
            Query query = this.getEntityManager().createQuery("SELECT e from Emprestimo e where e.id = :id");
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o empréstimo de id " + id + ". \nErro: " + e.getMessage());
        }
    }
    
    public List<Emprestimo> listByDataEmprestimo(Calendar dataEmprestimo){
        try {
            Query query = this.getEntityManager().createQuery("SELECT e from Emprestimo e where e.dataEmprestimo = :dataEmprestimo");
            query.setParameter("dataEmprestimo", dataEmprestimo);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o empréstimo com a data de empréstimo informada. \nErro: " + e.getMessage());
        }
    }
    
    public List<Emprestimo> listByDataDevolucaoEsperada(Calendar dataDevolucaoEsperada){
        try {
            Query query = this.getEntityManager().createQuery("SELECT e from Emprestimo e where e.dataDataDevolucaoEsperada = :dataDevolucaoEsperada");
            query.setParameter("dataDevolucaoEsperada", dataDevolucaoEsperada);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o empréstimo com a data de dev. esperada informada. \nErro: " + e.getMessage());
        }
    }
    
    public List<Emprestimo> listByDataDevolucaoReal(Calendar dataDevolucaoReal){
        try {
            Query query = this.getEntityManager().createQuery("SELECT e from Emprestimo e where e.dataDevolucaoReal = :dataDevolucaoReal");
            query.setParameter("dataDevolucaoReal", dataDevolucaoReal);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o empréstimo com a data de dev. real informada. \nErro: " + e.getMessage());
        }
    }
    
    public List<Emprestimo> listByValor(Double valor){
        try {
            Query query = this.getEntityManager().createQuery("SELECT e from Emprestimo e where e.valorEmprestimo = :valor");
            query.setParameter("valor", valor);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o empréstimo com o valor informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Emprestimo> listByIdMembro(int idMembro){
        try {
            Query query = this.getEntityManager().createQuery("SELECT e from Emprestimo e where e.membro.id = :idMembro");
            query.setParameter("idMembro", idMembro);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o empréstimo com o membro informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Emprestimo> listByIdFuncionario(int idFuncionario){
        try {
            Query query = this.getEntityManager().createQuery("SELECT e from Emprestimo e where e.funcionario.id = :idFuncionario");
            query.setParameter("idFuncionario", idFuncionario);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o empréstimo com o funcionário informado. \nErro: " + e.getMessage());
        }
    }
}
