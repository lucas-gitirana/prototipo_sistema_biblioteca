/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gitir
 */
@Entity
@Table(name = "tb_funcionario")
@PrimaryKeyJoinColumn(referencedColumnName = "pes_id")
public class Funcionario extends Pessoa implements Serializable {
    
    @Column(name = "fun_cargo")
    private String cargo;
    
    @Column(name = "fun_data_admissao")
    @Temporal(TemporalType.DATE)
    private Calendar dataAdmissao;
    
    @Column(name = "fun_salario")
    private double salario;

    public Funcionario() {
    }

    public Funcionario(String cpf, String nome, Calendar dataNascimento, String cargo, Calendar dataAdmissao, double salario) {
        super(cpf, nome, dataNascimento);
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return "model.Funcionario[ id=" + super.getId() + " ]";
    }
    
}
