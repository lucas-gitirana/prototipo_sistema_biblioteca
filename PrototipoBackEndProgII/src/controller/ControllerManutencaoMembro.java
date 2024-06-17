/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoMembro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Membro;
import view.JFCadastroCliente;

/**
 *
 * @author gitir
 */
public class ControllerManutencaoMembro {
    
    private DaoMembro daoMembro;
    private JFCadastroCliente view;
    private Membro membro;
    
    public ControllerManutencaoMembro(JFCadastroCliente view) {
        super();
        this.daoMembro = new DaoMembro();
        this.view = view;        
    }

    public DaoMembro getDaoMembro() {
        return daoMembro;
    }

    public void setDaoMembro(DaoMembro daoMembro) {
        this.daoMembro = daoMembro;
    }

    public JFCadastroCliente getView() {
        return view;
    }

    public void setView(JFCadastroCliente view) {
        this.view = view;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }
    
    private Membro getMembroFromScreen() throws ParseException{
        String cpf = this.getView().getjTCpf().getText();            
        String nome = this.getView().getjTNome().getText();
        String nascimento = this.getView().getjTNascimento().getText();
        String cadastro = this.getView().getjTCadastro().getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Calendar dataCadastro = Calendar.getInstance();
        Date date = dateFormat.parse(cadastro);
        dataCadastro.setTime(date);

        Calendar dataNascimento = Calendar.getInstance();
        date = dateFormat.parse(nascimento);
        dataNascimento.setTime(date);

        Membro membro = new Membro(cpf, nome, dataNascimento, dataCadastro, getPlano(), getStatus());
        return membro;       
    }
    
    public boolean gravarMembro(){
        try {
            this.getDaoMembro().insert(this.getMembroFromScreen());
            JOptionPane.showMessageDialog(this.getView(), "Membro gravado com sucesso!");
            this.getView().getjBLimpar().doClick();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.getView(), e.getMessage());
            return false;
        }
    }
    
    public void alterarMembro(){
        try {
            this.getMembro().setCpf(this.getMembroFromScreen().getCpf());
            this.getMembro().setDataCadastro(this.getMembroFromScreen().getDataCadastro());
            this.getMembro().setDataNascimento(this.getMembroFromScreen().getDataNascimento());
            this.getMembro().setNome(this.getMembroFromScreen().getNome());
            this.getMembro().setPlano(this.getMembroFromScreen().getPlano());
            this.getMembro().setStatus(this.getMembroFromScreen().getStatus());
            this.daoMembro.update(this.getMembro());
            this.view.getjBLimpar().doClick();
            JOptionPane.showMessageDialog(view, "Membro alterado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
    public char getPlano(){        
        switch(this.getView().getjCBPlano().getSelectedItem().toString()){
            case "Básico":
                return 'B';
            case "Premium":
                return 'P';
        }
        return 0;
    }
    
    public char getStatus(){
        switch(this.getView().getjCBStatus().getSelectedItem().toString()){
            case "Ativo":
                return 'A';
            case "Inativo":
                return 'I';
        }
        return 0;
    }

    public void excluirMembro() {
        try {
            this.getDaoMembro().delete(this.getDaoMembro().list(this.getMembro().getId()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Não foi possível excluir o membro. Erro: "+e.getMessage());
        }
    }
    
}
