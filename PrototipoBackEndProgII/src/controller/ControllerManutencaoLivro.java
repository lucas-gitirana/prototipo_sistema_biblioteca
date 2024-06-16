/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.Livro;
import view.JFCadastroLivro;
import view.JFConsultaLivro;

/**
 *
 * @author gitir
 */
public class ControllerManutencaoLivro extends Controller{
    
    private JFCadastroLivro view;
    private Livro livro;
    
    public ControllerManutencaoLivro(JFCadastroLivro view) {
        super();
        this.view = view;
    }

    public JFCadastroLivro getView() {
        return view;
    }

    public void setView(JFCadastroLivro view) {
        this.view = view;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public boolean gravarLivro(){
        try {
            //int id = Integer.parseInt(this.getView().getjTId().getText());
            String titulo = this.view.getjTTitulo().getText();
            String nomeEditora = this.view.getjTEditora().getText();
            String nomeAutor = this.view.getjTAutor().getText();
            int numPaginas = Integer.parseInt(this.view.getjTNumPaginas().getText());
            String edicao = this.view.getjTEdicao().getText();
            
            Livro livro = new Livro(titulo, nomeAutor, nomeEditora, numPaginas, edicao);
            this.daoLivro.insert(livro);
            
            JOptionPane.showMessageDialog(view, "Livro gravado com sucesso!");
            this.view.getjBLimpar().doClick();
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
            return false;
        }
    }
}
