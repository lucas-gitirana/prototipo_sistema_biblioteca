/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoFuncionario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Livro;
import view.JFCadastroFuncionario;

/**
 *
 * @author gitir
 */
public class ControllerManutencaoFuncionario{
    
    private DaoFuncionario daoFuncionario;
    private JFCadastroFuncionario view;
    private Funcionario funcionario;

    public ControllerManutencaoFuncionario(JFCadastroFuncionario view) {
        super();
        this.daoFuncionario = new DaoFuncionario();
        this.view = view;        
    }

    public DaoFuncionario getDaoFuncionario() {
        return daoFuncionario;
    }

    public void setDaoFuncionario(DaoFuncionario daoFuncionario) {
        this.daoFuncionario = daoFuncionario;
    }
    
    public JFCadastroFuncionario getView() {
        return view;
    }

    public void setView(JFCadastroFuncionario view) {
        this.view = view;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public boolean gravarFuncionario(){
        try {
            //int id = Integer.parseInt(this.getView().getjTId().getText());
            String nome = this.getView().getjTNome().getText();
            String cpf = this.getView().getjTCpf().getText();
            String cargo = this.getView().getjTCargo().getText();
            double salario = Double.parseDouble(this.getView().getjTSalario().getText());
            String nascimento = this.getView().getjTNascimento().getText();
            String admissao = this.getView().getjTAdmissao().getText();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            Calendar dataAdmissao = Calendar.getInstance();
            Date date = dateFormat.parse(admissao);
            dataAdmissao.setTime(date);
            
            Calendar dataNascimento = Calendar.getInstance();
            date = dateFormat.parse(nascimento);
            dataNascimento.setTime(date);
            
            Funcionario funcionario = new Funcionario(cpf, nome, dataNascimento, cargo, dataAdmissao, salario);
            this.getDaoFuncionario().insert(funcionario);
            
            JOptionPane.showMessageDialog(this.getView(), "Funcionário gravado com sucesso!");
            this.getView().getjBLimpar().doClick();
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
            return false;
        }
    }      
}
