/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoLivro;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Livro;
import view.JFCadastroLivro;
import view.JFConsultaLivro;

/**
 *
 * @author gitir
 */
public class ControllerConsultaLivro extends Controller {
            
    private JFConsultaLivro view;

    public ControllerConsultaLivro(JFConsultaLivro view) {
        super();
        this.view = view;
    }
    
    public JFConsultaLivro getView() {
        return view;
    }

    public void setView(JFConsultaLivro view) {
        this.view = view;
    }
    
    public DefaultTableModel getTableFromScreen(){
        return (DefaultTableModel) this.view.getjTableLivros().getModel();
    }
    
    public void pesquisar(){        
        try {
            String filtroSelecionado = (String) this.getView().getJcbListaFiltros().getSelectedItem();
            List<Livro> livros = null;
            this.limparPesquisa();
            
            if(filtroSelecionado.isBlank() || this.getView().getJtPesquisa().getText().isBlank()){
                livros = this.daoLivro.listAll();
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
    
    public void imprimeValores(List<Livro> livros){
        for(Livro l : livros){
            this.getTableFromScreen().addRow(new String[]{String.valueOf(l.getId()),
                                                 l.getEdicao(), 
                                                 l.getNomeAutor(),
                                                 l.getNomeEditora(),
                                                 String.valueOf(l.getNumeroPaginas()),
                                                 l.getTitulo()});            
        }
    }
    
    public List<Livro> pesquisarWithFiltro(String filtroSelecionado, String valor){
        switch(filtroSelecionado){
            case "Id":
                return this.getDaoLivro().listById(Long.parseLong(valor));
            case "Edição":
                return this.getDaoLivro().listByEdicao(valor);
            case "Autor":
                return this.getDaoLivro().listByAutor(valor);
            case "Editora":
                return this.getDaoLivro().listByEditora(valor);
            case "Páginas":
                return this.getDaoLivro().listByNumPaginas(Integer.parseInt(valor));
            case "Título":
                return this.getDaoLivro().listByTitulo(valor);
        }
        return null;
    }
    
    public void limparPesquisa(){
        DefaultTableModel table = (DefaultTableModel) this.getView().getjTableLivros().getModel();
        table.setRowCount(0);
    }
    
    public Livro getLivroSelecionado(){
        int linha = this.getView().getjTableLivros().getSelectedRow();
        
        Long id = Long.parseLong(this.getTableFromScreen().getValueAt(linha, 0).toString());
        String edicao = this.getTableFromScreen().getValueAt(linha, 1).toString();
        String nomeAutor = this.getTableFromScreen().getValueAt(linha, 2).toString();
        String nomeEditora = this.getTableFromScreen().getValueAt(linha, 3).toString();
        int numPaginas = Integer.parseInt(this.getTableFromScreen().getValueAt(linha, 4).toString());
        String titulo = this.getTableFromScreen().getValueAt(linha, 5).toString();
        
        Livro livro = new Livro(titulo, nomeAutor, nomeEditora, numPaginas, edicao);
        livro.setId(id);
        return livro;
    }
}
