/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoEmprestimo;
import dao.DaoUnidade;
import javax.swing.JOptionPane;
import model.Emprestimo;
import model.Unidade;
import view.JFManutencaoUnidadeEmprestimo;

/**
 *
 * @author gitir
 */
public class ControllerManutencaoUnidadeEmprestimo {
    
    private DaoEmprestimo daoEmprestimo;
    private DaoUnidade daoUnidade;
    private JFManutencaoUnidadeEmprestimo view;
    private Emprestimo emprestimo;
    
    public ControllerManutencaoUnidadeEmprestimo(JFManutencaoUnidadeEmprestimo view) {        
        this.daoEmprestimo = new DaoEmprestimo();
        this.daoUnidade = new DaoUnidade();
        this.view = view;
    }

    public DaoEmprestimo getDaoEmprestimo() {
        return daoEmprestimo;
    }

    public void setDaoEmprestimo(DaoEmprestimo daoEmprestimo) {
        this.daoEmprestimo = daoEmprestimo;
    }

    public DaoUnidade getDaoUnidade() {
        return daoUnidade;
    }

    public void setDaoUnidade(DaoUnidade daoUnidade) {
        this.daoUnidade = daoUnidade;
    }
    
    public JFManutencaoUnidadeEmprestimo getView() {
        return view;
    }

    public void setView(JFManutencaoUnidadeEmprestimo view) {
        this.view = view;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    
    public void addUnidade(){
        try {
            Unidade unidade = daoUnidade.list(Long.parseLong(this.getView().getjTIdUnidade().getText()));
            if( unidade != null && unidade.getDisponibilidade() == 'S'){
                this.getEmprestimo().addUnidade(unidade);
                this.getEmprestimo().setValorEmprestimo(this.getEmprestimo().getUnidades().size() * 1.50);
                this.daoEmprestimo.update(this.getEmprestimo());
                
                unidade.setDisponibilidade('N');
                this.daoUnidade.update(unidade);
                
                JOptionPane.showMessageDialog(this.getView(), "Unidade adicionada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this.getView(), "A unidade informada não existe ou não está disponível.");
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), "Erro ao adicionar unidade. Erro: "+e.getMessage());
        }
    }
}
