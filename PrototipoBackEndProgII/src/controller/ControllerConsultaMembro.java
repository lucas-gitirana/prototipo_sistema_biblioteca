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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Membro;
import view.JFConsultaCliente;

/**
 *
 * @author gitir
 */
public class ControllerConsultaMembro {
    
    private JFConsultaCliente view;
    private DaoMembro daoMembro;

    public ControllerConsultaMembro(JFConsultaCliente view) {
        super();
        this.view = view;
        this.daoMembro = new DaoMembro();
    }
    
    public JFConsultaCliente getView() {
        return view;
    }

    public DaoMembro getDaoMembro() {
        return daoMembro;
    }

    public void setDaoMembro(DaoMembro daoMembro) {
        this.daoMembro = daoMembro;
    }
    
    public void setView(JFConsultaCliente view) {
        this.view = view;
    }
    
    public DefaultTableModel getTableFromScreen(){
        return (DefaultTableModel) this.view.getjTableMembros().getModel();
    }
    
    public void pesquisar(){        
        try {
            String filtroSelecionado = (String) this.getView().getjCBFiltro().getSelectedItem();
            List<Membro> livros = null;
            this.limparPesquisa();
            
            if(filtroSelecionado.isBlank() || this.getView().getjTPesquisa().getText().isBlank()){
                livros = this.daoMembro.listAll();
            } else {
                livros = this.pesquisarWithFiltro(filtroSelecionado, this.getView().getjTPesquisa().getText());
            }
            
            if(livros != null){
                this.imprimeValores(livros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
    public void imprimeValores(List<Membro> livros){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(Membro m : livros){
            this.getTableFromScreen().addRow(new String[]{String.valueOf(m.getId()),
                                                 m.getCpf(),
                                                 m.getNome(),
                                                 sdf.format(m.getDataNascimento().getTime()),
                                                 sdf.format(m.getDataCadastro().getTime()),                                                 
                                                 String.valueOf(m.getPlano()),
                                                 String.valueOf(m.getStatus())});
        }
    }
    
    public List<Membro> pesquisarWithFiltro(String filtroSelecionado, String valor) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
        switch(filtroSelecionado){
            case "Id":
                return this.getDaoMembro().listById(Long.parseLong(valor));
            case "CPF":
                return this.getDaoMembro().listByCpf(valor);
            case "Nome":
                return this.getDaoMembro().listByNome(valor);
            case "Data de Nascimento":
                Calendar dataNascimento = Calendar.getInstance();
                Date nascDate = sdf.parse(valor);
                dataNascimento.setTime(nascDate);
                return this.getDaoMembro().listByDataNascimento(dataNascimento);
            case "Data de Cadastro":
                Calendar dataCadastro = Calendar.getInstance();
                Date cadDate = sdf.parse(valor);
                dataCadastro.setTime(cadDate);
                return this.getDaoMembro().listByDataCadastro(dataCadastro);
            case "Plano":
                return this.getDaoMembro().listByPlano(valor.toUpperCase().charAt(0));
            case "Status":
                return this.getDaoMembro().listByStatus(valor.toUpperCase().charAt(0));
        }
        return null;
    }
    
    public void limparPesquisa(){
        DefaultTableModel table = (DefaultTableModel) this.getView().getjTableMembros().getModel();
        table.setRowCount(0);
    }
}
