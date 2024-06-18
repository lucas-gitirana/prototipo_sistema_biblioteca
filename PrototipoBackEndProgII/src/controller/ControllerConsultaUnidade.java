/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoUnidade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Unidade;
import view.JFConsultaUnidade;

/**
 *
 * @author gitir
 */
public class ControllerConsultaUnidade {
    
    private JFConsultaUnidade view;
    private DaoUnidade daoUnidade;

    public ControllerConsultaUnidade(JFConsultaUnidade view) {
        super();
        this.view = view;
        this.daoUnidade = new DaoUnidade();
    }
    
    public JFConsultaUnidade getView() {
        return view;
    }

    public DaoUnidade getDaoUnidade() {
        return daoUnidade;
    }

    public void setDaoUnidade(DaoUnidade daoUnidade) {
        this.daoUnidade = daoUnidade;
    }
    
    public void setView(JFConsultaUnidade view) {
        this.view = view;
    }
    
    public DefaultTableModel getTableFromScreen(){
        return (DefaultTableModel) this.view.getjTableUnidades().getModel();
    }
    
    public void pesquisar(){
        try {
            String filtroSelecionado = (String) this.getView().getjCBFiltros().getSelectedItem();
            List<Unidade> livros = null;
            this.limparPesquisa();
            
            if(filtroSelecionado.isBlank() || this.getView().getJtPesquisa().getText().isBlank()){
                livros = this.daoUnidade.listAll();
            } else {
                livros = this.pesquisarWithFiltro(filtroSelecionado, this.getView().getJtPesquisa().getText());
            }
            
            if(livros != null){
                this.imprimeValores(livros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
    public void imprimeValores(List<Unidade> livros){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(Unidade u : livros){
            this.getTableFromScreen().addRow(new String[]{String.valueOf(u.getId()),
                                                 String.valueOf(u.getLivro().getId()),
                                                 u.getLivro().getTitulo(),
                                                 String.valueOf(u.getDisponibilidade()),
                                                 sdf.format(u.getDataCompra().getTime())});
        }
    }
    
    public List<Unidade> pesquisarWithFiltro(String filtroSelecionado, String valor) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
        switch(filtroSelecionado){
            case "Id":
                return this.getDaoUnidade().listById(Long.parseLong(valor));
            case "Código - Livro":
                return this.getDaoUnidade().listByIdLivro(Long.parseLong(valor));
            case "Título - Livro":
                return this.getDaoUnidade().listByTituloLivro(valor);
            case "Disponibilidade":
                return this.getDaoUnidade().listByDisponibilidade(valor.toUpperCase().charAt(0));
            case "Data de Compra":
                Calendar dataCompra = Calendar.getInstance();
                Date admDate = sdf.parse(valor);
                dataCompra.setTime(admDate);                
                return this.getDaoUnidade().listByDataCompra(dataCompra);
        }
        return null;
    }
    
    public void limparPesquisa(){
        DefaultTableModel table = (DefaultTableModel) this.getView().getjTableUnidades().getModel();
        table.setRowCount(0);
    }
    
    public Unidade getUnidadeSelecionada(){
        try {
            int linha = this.getView().getjTableUnidades().getSelectedRow();
            Long id = Long.parseLong(this.getTableFromScreen().getValueAt(linha, 0).toString());
            return this.getDaoUnidade().list(id);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this.getView(), "Não foi possível carregar a unidade. Erro: "+e.getMessage());
            return null;
        }
    }
    
}
