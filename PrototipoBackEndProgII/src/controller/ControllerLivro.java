/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoLivro;
import model.Livro;

/**
 *
 * @author gitir
 */
public class ControllerLivro {
    
    private Livro livro;
    private DaoLivro daoLivro;
    
    public ControllerLivro(Livro livro) {
        this.livro = livro;
        this.daoLivro = new DaoLivro();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public boolean gravarLivro(){
        try {
            this.daoLivro.insert(this.livro);
            return true;            
        } catch (Exception e) {
            return false;
        }
    }
    
}
