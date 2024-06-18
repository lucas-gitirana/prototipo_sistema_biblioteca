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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Emprestimo;
import model.Unidade;
import view.JFManutencaoDevolverEmprestimo;

/**
 *
 * @author gitir
 */
public class ControllerManutencaoDevolverEmprestimo {
    
    private JFManutencaoDevolverEmprestimo view;
    private Emprestimo emprestimo;
    private DaoEmprestimo daoEmprestimo;

    public ControllerManutencaoDevolverEmprestimo(JFManutencaoDevolverEmprestimo view) {
        this.daoEmprestimo = new DaoEmprestimo();
        this.view = view;
    }

    public JFManutencaoDevolverEmprestimo getView() {
        return view;
    }

    public void setView(JFManutencaoDevolverEmprestimo view) {
        this.view = view;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public DaoEmprestimo getDaoEmprestimo() {
        return daoEmprestimo;
    }

    public void setDaoEmprestimo(DaoEmprestimo daoEmprestimo) {
        this.daoEmprestimo = daoEmprestimo;
    }

    public void carregaValorMulta() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar dataDevolucao = Calendar.getInstance();
            Date date = dateFormat.parse(this.getView().getjTDataDevolucao().getText());
            dataDevolucao.setTime(date);
            Calendar dataDevEsperada = this.getEmprestimo().getDataDataDevolucaoEsperada();
            Calendar dataEmprestimo = this.getEmprestimo().getDataEmprestimo();
            
            if(dataDevolucao.after(dataEmprestimo)){
                if(dataDevEsperada.after(dataDevolucao)){
                    this.getView().getjTValorMulta().setText("0.00");
                    this.getView().getjTValorMulta().setEnabled(false);
                } else {
                    long emprestimo = dataDevEsperada.getTimeInMillis();
                    long devolucao = dataDevolucao.getTimeInMillis();
                    long diferenca = devolucao - emprestimo;

                    Double valor = TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS) * 1.25;

                    this.getView().getjTValorMulta().setText(String.valueOf(valor));
                    this.getView().getjTValorMulta().setEnabled(true);
                }
                
            } else if(dataEmprestimo.after(dataDevolucao)){
                this.getView().getjTValorMulta().setText("");
                this.getView().getjTValorMulta().setEnabled(true);
                this.getView().getjTDataDevolucao().setText("");
                JOptionPane.showMessageDialog(this.getView(), "A data de devolução deve ser maior que a de empréstimo!");
            }
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this.getView(), "Valor inválido");
            this.getView().getjTDataDevolucao().setText("");
        }
    }

    public void devolverEmprestimo() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar dataDevolucao = Calendar.getInstance();
            Date date = dateFormat.parse(this.getView().getjTDataDevolucao().getText());
            dataDevolucao.setTime(date);
            
            this.getEmprestimo().setDataDevolucaoReal(dataDevolucao);
            this.getEmprestimo().setValorEmprestimo(Double.parseDouble(this.getView().getjTValorMulta().getText()));
            this.getDaoEmprestimo().update(this.getEmprestimo());
            
            DaoUnidade daoUnidade = new DaoUnidade();
            for(Unidade u : this.getEmprestimo().getUnidades()){
                u.setDisponibilidade('S');
                daoUnidade.update(u);
            }
            
            JOptionPane.showMessageDialog(view, "Empréstimo devolvido com sucesso!");
            this.getView().getjBLimpar().doClick();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
        }
    }

    public void desatualizarEmprestimo(Emprestimo emprestimoSelecionado) {
        try {
            emprestimoSelecionado.setDataDevolucaoReal(null);
            emprestimoSelecionado.setValorEmprestimo(0);
            this.daoEmprestimo.update(emprestimoSelecionado);
            
            DaoUnidade daoUnidade = new DaoUnidade();
            for(Unidade u : emprestimoSelecionado.getUnidades()){
                u.setDisponibilidade('N');
                daoUnidade.update(u);
            }
            
            JOptionPane.showMessageDialog(view, "Empréstimo desatualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
        }
    }
    
    
    
    
}
