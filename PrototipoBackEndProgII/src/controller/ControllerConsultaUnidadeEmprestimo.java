/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoEmprestimo;
import dao.DaoUnidade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    private DaoUnidade daoUnidade;
    private Emprestimo emprestimo;

    public ControllerConsultaUnidadeEmprestimo(JFConsultaUnidadeEmprestimo view) {        
        this.view = view;
        this.daoEmprestimo = new DaoEmprestimo();
        this.daoUnidade = new DaoUnidade();
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

    public DaoUnidade getDaoUnidade() {
        return daoUnidade;
    }

    public void setDaoUnidade(DaoUnidade daoUnidade) {
        this.daoUnidade = daoUnidade;
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
                unidades = this.pesquisarWithFiltro(filtroSelecionado, this.getView().getJtPesquisa().getText());
            }
            
            if(unidades != null && unidades.get(0) != null){
                this.imprimeValores(unidades);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
    public void imprimeValores(List<Unidade> unidades){        
        for(Unidade u : unidades){
            this.getTableFromScreen().addRow(new String[]{String.valueOf(u.getId()),
                                                 String.valueOf(u.getLivro().getId()),
                                                 u.getLivro().getTitulo()});
        }
    }
    
    public List<Unidade> pesquisarWithFiltro(String filtroSelecionado, String valor) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        switch(filtroSelecionado){
            case "Código - Unidade":
                return this.getDaoUnidade().listById(Long.parseLong(valor));
            case "Código - Livro":
                return this.getDaoUnidade().listByIdLivro(Long.parseLong(valor));
            case "Título - Livro":
                return this.getDaoUnidade().listByTituloLivro(valor);
        }
        return null;
    }

    private void limparPesquisa() {
        this.getTableFromScreen().setRowCount(0);
    }

    public Unidade getUnidadeSelecionada() {
        try {
            int linha = this.getView().getjTableUnidadesEmprestimo().getSelectedRow();
            Long id = Long.parseLong(this.getTableFromScreen().getValueAt(linha, 0).toString());
            return this.getDaoUnidade().list(id);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this.getView(), "Não foi possível carregar a unidade. Erro: "+e.getMessage());
            return null;
        }
    }
    
}
