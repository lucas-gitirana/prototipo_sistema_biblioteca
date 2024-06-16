/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoEmprestimo;
import dao.DaoFuncionario;
import dao.DaoMembro;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Emprestimo;
import model.Funcionario;
import model.Membro;
import view.JFManutencaoEmprestimo;

/**
 *
 * @author gitir
 */
public class ControllerManutencaoEmprestimo {
    
    private DaoEmprestimo daoEmprestimo;
    private JFManutencaoEmprestimo view;
    private Emprestimo emprestimo;
    
    public ControllerManutencaoEmprestimo(JFManutencaoEmprestimo view) {
        super();
        this.daoEmprestimo = new DaoEmprestimo();
        this.view = view;        
    }

    public DaoEmprestimo getDaoEmprestimo() {
        return daoEmprestimo;
    }

    public void setDaoEmprestimo(DaoEmprestimo daoEmprestimo) {
        this.daoEmprestimo = daoEmprestimo;
    }

    public JFManutencaoEmprestimo getView() {
        return view;
    }

    public void setView(JFManutencaoEmprestimo view) {
        this.view = view;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    
    public boolean gravarEmprestimo(){
        try {
            //int id = Integer.parseInt(this.getView().getjTId().getText());
            Long idMembro = Long.parseLong(this.getView().getjTIdCliente().getText());
            Long idFuncionario = Long.parseLong(this.getView().getjTIdFuncionario().getText());
            Double valor = Double.parseDouble(this.getView().getjTValor().getText());
            String emprestimoData = this.getView().getjTDataEmprestimo().getText();
            String devolucao = this.getView().getjTDataDevolucao().getText();
            
            Membro membro = getMembro(idMembro);
            Funcionario funcionario = getFuncionario(idFuncionario);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            Calendar dataEmprestimo = Calendar.getInstance();
            Date date = dateFormat.parse(emprestimoData);
            dataEmprestimo.setTime(date);
            
            Calendar dataDevolucao = Calendar.getInstance();
            date = dateFormat.parse(devolucao);
            dataDevolucao.setTime(date);
            
            if(membro != null && funcionario != null){
                Emprestimo emprestimo = new Emprestimo(dataEmprestimo, dataDevolucao, valor, membro, funcionario);
                this.getDaoEmprestimo().insert(emprestimo);
                JOptionPane.showMessageDialog(this.getView(), "Empréstimo gravado com sucesso!");
                this.getView().getjBLimpar().doClick();
            } else {                
                return false;
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
            return false;
        }
    }
    
    public Membro getMembro(Long idMembro){
        try{
            DaoMembro daoMembro = new DaoMembro();
            Membro m = daoMembro.list(idMembro);
            if(m == null){
                JOptionPane.showMessageDialog(this.getView(), "O membro informado não existe.");
            }
            return m;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
            return null;
        }
    }
    
    public Funcionario getFuncionario(Long idFuncionario){
        try{
            DaoFuncionario daoFuncionario = new DaoFuncionario();
            Funcionario f = daoFuncionario.list(idFuncionario);
            if(f == null){
                JOptionPane.showMessageDialog(this.getView(), "O membro informado não existe.");
            }
            return f;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
            return null;
        }
    }    
}
