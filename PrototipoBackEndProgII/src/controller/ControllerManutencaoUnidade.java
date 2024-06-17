/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoLivro;
import dao.DaoUnidade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Livro;
import model.Unidade;
import view.JFManutencaoUnidade;

/**
 *
 * @author gitir
 */
public class ControllerManutencaoUnidade {
    
    private DaoUnidade daoUnidade;
    private JFManutencaoUnidade view;
    private Unidade unidade;

    public ControllerManutencaoUnidade(JFManutencaoUnidade view) {        
        this.daoUnidade = new DaoUnidade();
        this.view = view;        
    }

    public DaoUnidade getDaoUnidade() {
        return daoUnidade;
    }

    public void setDaoUnidade(DaoUnidade daoUnidade) {
        this.daoUnidade = daoUnidade;
    }

    public JFManutencaoUnidade getView() {
        return view;
    }

    public void setView(JFManutencaoUnidade view) {
        this.view = view;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
    
    private Unidade getUnidadeFromScreen() throws ParseException{
        Long idLivro = Long.parseLong(this.getView().getjTLivro().getText());
        String compra = this.getView().getjTCompra().getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Livro livro = getLivro(idLivro);
        
        Calendar dataAdmissao = Calendar.getInstance();
        Date date = dateFormat.parse(compra);
        dataAdmissao.setTime(date);
        
        Unidade unidade = new Unidade(getDisponibilidade(), dataAdmissao, livro);
        return unidade;
    }
    
    public boolean gravarUnidade(){
        try {
            if(this.getUnidadeFromScreen().getLivro() != null){
                this.getDaoUnidade().insert(this.getUnidadeFromScreen());
                JOptionPane.showMessageDialog(this.getView(), "Unidade gravada com sucesso!");
                this.getView().getjBLimpar().doClick();
                return true;
            } else {
                JOptionPane.showMessageDialog(this.getView(), "O livro informado não existe.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
            return false;
        }
    }
    
    public void alterarUnidade() {
        try {
            if(this.getUnidadeFromScreen().getLivro() != null){
                this.getUnidade().setLivro(this.getUnidadeFromScreen().getLivro());
                this.getUnidade().setDataCompra(this.getUnidadeFromScreen().getDataCompra());
                this.getUnidade().setDisponibilidade(this.getUnidadeFromScreen().getDisponibilidade());
                this.daoUnidade.update(this.getUnidade());
                this.view.getjBLimpar().doClick();
                JOptionPane.showMessageDialog(view, "Unidade alterada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this.getView(), "O livro informado não existe.");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
    public Livro getLivro(Long idLivro){
        try{
            DaoLivro daoLivro = new DaoLivro();            
            return daoLivro.list(idLivro);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
            return null;
        }
    }
    
    public char getDisponibilidade(){        
        switch(this.getView().getjCBDisponibilidade().getSelectedItem().toString()){
            case "Sim":
                return 'S';
            case "Não":
                return 'N';
        }
        return 0;
    }

    public void excluirUnidade() {
        try {
            this.getDaoUnidade().delete(this.getDaoUnidade().list(this.getUnidade().getId()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Não foi possível excluir a unidade. Erro: "+e.getMessage());
        }
    }
}
