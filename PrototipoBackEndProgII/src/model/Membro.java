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
@Table(name = "tb_membro")
@PrimaryKeyJoinColumn(referencedColumnName = "pes_id")
public class Membro extends Pessoa implements Serializable {
    
    @Column(name = "mem_data_cadastro")
    @Temporal(TemporalType.DATE)
    private Calendar dataCadastro;
    
    @Column(name = "mem_plano")
    private char plano;
    
    @Column(name = "mem_status")
    private char status;

    public Membro() {
    }

    public Membro(String cpf, String nome, Calendar dataNascimento, Calendar dataCadastro, char plano, char status) {
        super(cpf, nome, dataNascimento);
        this.dataCadastro = dataCadastro;
        this.plano = plano;
        this.status = status;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public char getPlano() {
        return plano;
    }

    public void setPlano(char plano) {
        this.plano = plano;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "model.Membro[ id=" + super.getId() + " ]";
    }
    
}
