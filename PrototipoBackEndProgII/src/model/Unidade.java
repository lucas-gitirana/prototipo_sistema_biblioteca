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
@Table(name = "tb_unidade")
public class Unidade implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uni_id")
    private Long id;
    
    @Column(name = "uni_disponibilidade")
    private char disponibilidade;
    
    @Column(name = "uni_data_compra")
    @Temporal(TemporalType.DATE)
    private Calendar dataCompra;
    
    @ManyToOne
    @JoinColumn(name = "liv_id")
    private Livro livro;
    
    @ManyToMany(mappedBy = "unidades")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Unidade() {
    }

    public Unidade(char disponibilidade, Calendar dataCompra, Livro livro) {
        this.disponibilidade = disponibilidade;
        this.dataCompra = dataCompra;
        this.livro = livro;
    }

    public Long getId() {
        return id;
    }

    public char getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(char disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    @Override
    public String toString() {
        return "model.Unidade[ id=" + id + " ]";
    }
    
}
