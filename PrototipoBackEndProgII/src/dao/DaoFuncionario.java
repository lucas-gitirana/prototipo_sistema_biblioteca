/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Calendar;
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
    
    public List<Funcionario> listById(Long id){
        try {
            Query query = this.getEntityManager().createQuery("SELECT f from Funcionario f where f.id = :id");
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o funcionário de id " + id + ". \nErro: " + e.getMessage());
        }
    }
    
    public List<Funcionario> listByCpf(String cpf){
        try {
            Query query = this.getEntityManager().createQuery("SELECT f from Funcionario f where f.cpf = :cpf");
            query.setParameter("cpf", cpf);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o funcionário com o CPF informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Funcionario> listByNome(String nome){
        try {
            Query query = this.getEntityManager().createQuery("SELECT f from Funcionario f where f.nome = :nome");
            query.setParameter("nome", nome);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar o funcionário com o nome informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Funcionario> listByCargo(String cargo){
        try {
            Query query = this.getEntityManager().createQuery("SELECT f from Funcionario f where f.cargo = :cargo");
            query.setParameter("cargo", cargo);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os funcionários com o cargo informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Funcionario> listByEditora(String cargo){
        try {
            Query query = this.getEntityManager().createQuery("SELECT f from Funcionario f where f.cargp = :cargo");
            query.setParameter("cargo", cargo);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os funcionários com o cargo informado. \nErro: " + e.getMessage());
        }
    }
    
    public List<Funcionario> listByDataAdmissao (Calendar dataAdmissao){
        try {
            Query query = this.getEntityManager().createQuery("SELECT f from Funcionario f where f.dataAdmissao = :dataAdmissao");
            query.setParameter("dataAdmissao", dataAdmissao);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os funcionários com a data de admissão informada. \nErro: " + e.getMessage());
        }
    }
    
    public List<Funcionario> listByDataNascimento (Calendar dataNascimento){
        try {
            Query query = this.getEntityManager().createQuery("SELECT f from Funcionario f where f.dataNascimento = :dataNascimento");
            query.setParameter("dataNascimento", dataNascimento);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os funcionários com a data de nascimento informada. \nErro: " + e.getMessage());
        }
    }
    
    public List<Funcionario> listBySalario (Double salario){
        try {
            Query query = this.getEntityManager().createQuery("SELECT f from Funcionario f where f.salario = :salario");
            query.setParameter("salario", salario);
            return query.getResultList();
        } catch (Exception e) {
            this.getEntityManager().close();
            throw new RuntimeException("Não foi possível carregar os funcionários com o salário informado. \nErro: " + e.getMessage());
        }
    }
}
