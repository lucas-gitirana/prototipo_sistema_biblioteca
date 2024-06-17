/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoEmprestimo;
import dao.DaoFuncionario;
import dao.DaoMembro;
import java.text.ParseException;
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
    
    private Emprestimo getEmprestimoFromScreen() throws ParseException{
        Long idMembro = Long.parseLong(this.getView().getjTIdCliente().getText());
            Long idFuncionario = Long.parseLong(this.getView().getjTIdFuncionario().getText());
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
            
            Emprestimo emprestimo = new Emprestimo(dataEmprestimo, dataDevolucao, 0.00, membro, funcionario);
            return emprestimo;
    }
    
    public boolean gravarEmprestimo(){
        try {
            if(this.getEmprestimoFromScreen().getMembro() != null && this.getEmprestimoFromScreen().getFuncionario() != null){
                this.getDaoEmprestimo().insert(this.getEmprestimoFromScreen());
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
    
    public void alterarEmprestimo() {
        try {
            if(this.getEmprestimoFromScreen().getMembro() != null && this.getEmprestimoFromScreen().getFuncionario() != null){
                this.getEmprestimo().setDataDataDevolucaoEsperada(this.getEmprestimoFromScreen().getDataDataDevolucaoEsperada());
                this.getEmprestimo().setDataDevolucaoReal(this.getEmprestimoFromScreen().getDataDevolucaoReal());
                this.getEmprestimo().setDataEmprestimo(this.getEmprestimoFromScreen().getDataEmprestimo());
                this.getEmprestimo().setFuncionario(this.getEmprestimoFromScreen().getFuncionario());
                this.getEmprestimo().setMembro(this.getEmprestimoFromScreen().getMembro());
                this.getEmprestimo().setValorEmprestimo(this.getEmprestimoFromScreen().getValorEmprestimo());
                this.daoEmprestimo.update(this.getEmprestimo());
                this.getView().getjBLimpar().doClick();
                JOptionPane.showMessageDialog(view, "Empréstimo alterado com sucesso!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), "O empréstimo informado não existe.");
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

    public void excluirEmprestimo() {
        try {
            this.getDaoEmprestimo().delete(this.getDaoEmprestimo().list(this.getEmprestimo().getId()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Não foi possível excluir o empréstimo. Erro: "+e.getMessage());
        }
    }
}
