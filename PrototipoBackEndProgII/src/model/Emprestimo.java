/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gitir
 */
@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long id;
    
    @Column(name = "emp_data_emprestimo")
    @Temporal(TemporalType.DATE)
    private Calendar dataEmprestimo;
    
    @Column(name = "emp_data_devolucao_esperada")
    @Temporal(TemporalType.DATE)
    private Calendar dataDataDevolucaoEsperada;
    
    @Column(name = "emp_data_devolucao_real")
    @Temporal(TemporalType.DATE)
    private Calendar dataDevolucaoReal;
    
    @Column(name = "emp_valor")
    private double valorEmprestimo;
    
    @ManyToOne
    @JoinColumn(name = "mem_id")
    private Pessoa membro;
    
    @ManyToOne
    @JoinColumn(name = "fun_id")
    private Pessoa funcionario;
    
    @ManyToMany
    @JoinTable(name = "tb_emprestimo_unidade",
               joinColumns = @JoinColumn(name = "emp_id"),
               inverseJoinColumns = @JoinColumn(name = "uni_id"))
    private List<Unidade> unidades = new ArrayList<>();

    public Emprestimo() {
    }

    public Emprestimo(Calendar dataEmprestimo, Calendar dataDataDevolucaoEsperada, Calendar dataDevolucaoReal, double valorEmprestimo, Pessoa membro, Pessoa funcionario) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDataDevolucaoEsperada = dataDataDevolucaoEsperada;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.valorEmprestimo = valorEmprestimo;
        this.membro = membro;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public Calendar getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Calendar dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Calendar getDataDataDevolucaoEsperada() {
        return dataDataDevolucaoEsperada;
    }

    public void setDataDataDevolucaoEsperada(Calendar dataDataDevolucaoEsperada) {
        this.dataDataDevolucaoEsperada = dataDataDevolucaoEsperada;
    }

    public Calendar getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(Calendar dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public Pessoa getMembro() {
        return membro;
    }

    public void setMembro(Pessoa membro) {
        this.membro = membro;
    }

    public Pessoa getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }
    
    public void addUnidade(Unidade u){
        this.getUnidades().add(u);
    }
    
    @Override
    public String toString() {
        return "model.Emprestimo[ id=" + id + " ]";
    }

}
