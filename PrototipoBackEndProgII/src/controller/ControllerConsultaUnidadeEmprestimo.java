/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoEmprestimo;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Emprestimo;
import model.Unidade;
import view.JFConsultaUnidadeEmprestimo;

/**
 *
 * @author gitir
 */
public class ControllerConsultaUnidadeEmprestimo {
    
    private JFConsultaUnidadeEmprestimo view;
    private DaoEmprestimo daoEmprestimo;
    private Emprestimo emprestimo;

    public ControllerConsultaUnidadeEmprestimo(JFConsultaUnidadeEmprestimo view) {        
        this.view = view;
        this.daoEmprestimo = new DaoEmprestimo();
    }

    public JFConsultaUnidadeEmprestimo getView() {
        return view;
    }

    public void setView(JFConsultaUnidadeEmprestimo view) {
        this.view = view;
    }

    public DaoEmprestimo getDaoEmprestimo() {
        return daoEmprestimo;
    }

    public void setDaoEmprestimo(DaoEmprestimo daoEmprestimo) {
        this.daoEmprestimo = daoEmprestimo;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    
    public DefaultTableModel getTableFromScreen(){
        return (DefaultTableModel) this.view.getjTableUnidadesEmprestimo().getModel();
    }
    
    public void pesquisar(){
        try {
            String filtroSelecionado = (String) this.getView().getjCBFiltros().getSelectedItem();
            List<Unidade> unidades = null;
            this.limparPesquisa();
            
            if(filtroSelecionado.isBlank() || this.getView().getJtPesquisa().getText().isBlank()){
                unidades = this.getDaoEmprestimo().listUnidades(this.getEmprestimo().getId());
            } else {
                //unidades = this.pesquisarWithFiltro(filtroSelecionado, this.getView().getJtPesquisa().getText());
            }
            
            if(unidades != null){
                this.imprimeValores(unidades);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
    public void imprimeValores(List<Unidade> unidades){        
        for(Unidade u : unidades){
            this.getTableFromScreen().addRow(new String[]{String.valueOf(u.getId()),
                                                 String.valueOf(u.getLivro().getId())});
        }
    }

    private void limparPesquisa() {
        this.getTableFromScreen().setRowCount(0);
    }
    
}
