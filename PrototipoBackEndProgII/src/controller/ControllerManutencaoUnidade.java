/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoLivro;
import dao.DaoUnidade;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
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
        super();
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
    
    public boolean gravarUnidade(){
        try {
            //int id = Integer.parseInt(this.getView().getjTId().getText());
            Long idLivro = Long.parseLong(this.getView().getjTLivro().getText());
            String compra = this.getView().getjTCompra().getText();
            Livro livro = getLivro(idLivro);
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            Calendar dataAdmissao = Calendar.getInstance();
            Date date = dateFormat.parse(compra);
            dataAdmissao.setTime(date);
            
            if(livro != null){
                Unidade unidade = new Unidade(getDisponibilidade(), dataAdmissao, livro);
                this.getDaoUnidade().insert(unidade);
                JOptionPane.showMessageDialog(this.getView(), "Unidade gravada com sucesso!");
                this.getView().getjBLimpar().doClick();
            } else {
                JOptionPane.showMessageDialog(this.getView(), "O livro informado não existe.");
                return false;
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
            return false;
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
}
