/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gitir
 */
@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "liv_id")
    private Long id;
    
    @Column(name = "liv_titulo", nullable = false)
    private String titulo;
    
    @Column(name = "liv_nome_autor", nullable = false)
    private String nomeAutor;
    
    @Column(name = "liv_nome_editora", nullable = false)
    private String nomeEditora;
    
    @Column(name = "liv_num_paginas", nullable = false)
    private int numeroPaginas;
    
    @Column(name = "liv_edicao", nullable = false)
    private String edicao;

    public Livro() {
    }

    public Livro(String titulo, String nomeAutor, String nomeEditora, int numeroPaginas, String edicao) {        
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.nomeEditora = nomeEditora;
        this.numeroPaginas = numeroPaginas;
        this.edicao = edicao;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    
    @Override
    public String toString() {
        return "model.Livro[ id=" + id + " ]";
    }
    
}
