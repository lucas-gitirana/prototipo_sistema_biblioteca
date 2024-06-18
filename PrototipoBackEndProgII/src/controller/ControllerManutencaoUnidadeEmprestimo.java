/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoEmprestimo;
import dao.DaoUnidade;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    private Unidade unidade;
    
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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
    
    public void addUnidade(){
        try {
            Unidade unidade = daoUnidade.list(Long.parseLong(this.getView().getjTIdUnidade().getText()));
            if( unidade != null && unidade.getDisponibilidade() == 'S'){
                this.getEmprestimo().addUnidade(unidade);                
                this.daoEmprestimo.update(this.getEmprestimo());
                
                unidade.setDisponibilidade('N');
                this.daoUnidade.update(unidade);
                
                this.getView().getjBLimpar().doClick();
                JOptionPane.showMessageDialog(this.getView(), "Unidade adicionada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this.getView(), "A unidade informada não existe ou não está disponível.");
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), "Erro ao adicionar unidade. Erro: "+e.getMessage());
        }
    }

    public void removerUnidade(Unidade unidade) {
        try {
            List<Unidade> unidades = this.getEmprestimo().getUnidades();
            Iterator<Unidade> iterator = unidades.iterator();
            
            while (iterator.hasNext()) {
                Unidade u = iterator.next();
                if (u.getId() == unidade.getId()) {
                    iterator.remove();
                    u.setDisponibilidade('S');
                    this.getDaoUnidade().update(u);
                }
            }
            
            Emprestimo e = this.getDaoEmprestimo().list(this.getEmprestimo().getId());
            e.setUnidades(unidades);
            this.getDaoEmprestimo().update(e);
            
            JOptionPane.showMessageDialog(this.getView(), "Unidade removida com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Não foi possível excluir a unidade. Erro: "+e.getMessage());
        }
    }
}
