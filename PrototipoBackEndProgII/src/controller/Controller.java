/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoLivro;

/**
 *
 * @author gitir
 */
public abstract class Controller {
    
    protected DaoLivro daoLivro;

    public Controller() {
        this.daoLivro = new DaoLivro();
    }

    public DaoLivro getDaoLivro() {
        return daoLivro;
    }

    public void setDaoLivro(DaoLivro daoLivro) {
        this.daoLivro = daoLivro;
    }
}
