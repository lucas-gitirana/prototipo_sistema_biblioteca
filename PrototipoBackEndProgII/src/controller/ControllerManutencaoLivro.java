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
    
    private Livro getLivroFromScreen(){
        String titulo = this.view.getjTTitulo().getText();
        String nomeEditora = this.view.getjTEditora().getText();
        String nomeAutor = this.view.getjTAutor().getText();
        int numPaginas = Integer.parseInt(this.view.getjTNumPaginas().getText());
        String edicao = this.view.getjTEdicao().getText();

        Livro livro = new Livro(titulo, nomeAutor, nomeEditora, numPaginas, edicao);
        return livro;
    }
    
    public boolean gravarLivro(){
        try {
            this.daoLivro.insert(this.getLivroFromScreen());
            this.view.getjBLimpar().doClick();
            JOptionPane.showMessageDialog(view, "Livro gravado com sucesso!");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
            return false;
        }
    }

    public boolean alterarLivro() {
        try {
            this.getLivro().setEdicao(this.getLivroFromScreen().getEdicao());
            this.getLivro().setNomeAutor(this.getLivroFromScreen().getNomeAutor());
            this.getLivro().setNomeEditora(this.getLivroFromScreen().getNomeEditora());
            this.getLivro().setNumeroPaginas(this.getLivroFromScreen().getNumeroPaginas());
            this.getLivro().setTitulo(this.getLivroFromScreen().getTitulo());
            this.daoLivro.update(this.getLivro());
            this.view.getjBLimpar().doClick();
            JOptionPane.showMessageDialog(view, "Livro alterado com sucesso!");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
            return false;
        }
    }

    public void excluirLivro() {
        try {
            this.getDaoLivro().delete(this.getDaoLivro().list(this.getLivro().getId()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Não foi possível excluir o livro. Erro: "+e.getMessage());
        }
    }
}
