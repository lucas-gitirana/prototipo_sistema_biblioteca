/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoFuncionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import view.JFConsultaFuncionario;

/**
 *
 * @author gitir
 */
public class ControllerConsultaFuncionario {
    
    private JFConsultaFuncionario view;
    private DaoFuncionario daoFuncionario;

    public ControllerConsultaFuncionario(JFConsultaFuncionario view) {
        super();
        this.view = view;
        this.daoFuncionario = new DaoFuncionario();
    }
    
    public JFConsultaFuncionario getView() {
        return view;
    }

    public DaoFuncionario getDaoFuncionario() {
        return daoFuncionario;
    }

    public void setDaoFuncionario(DaoFuncionario daoFuncionario) {
        this.daoFuncionario = daoFuncionario;
    }
    
    public void setView(JFConsultaFuncionario view) {
        this.view = view;
    }
    
    public DefaultTableModel getTableFromScreen(){
        return (DefaultTableModel) this.view.getjTableFuncionarios().getModel();
    }
    
    public void pesquisar(){        
        try {
            String filtroSelecionado = (String) this.getView().getjCBFiltro().getSelectedItem();
            List<Funcionario> livros = null;
            this.limparPesquisa();
            
            if(filtroSelecionado.isBlank() || this.getView().getjTPesquisa().getText().isBlank()){
                livros = this.daoFuncionario.listAll();
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
    
    public void imprimeValores(List<Funcionario> livros){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(Funcionario f : livros){
            this.getTableFromScreen().addRow(new String[]{String.valueOf(f.getId()),
                                                 f.getCpf(),
                                                 f.getNome(),
                                                 f.getCargo(),
                                                 sdf.format(f.getDataAdmissao().getTime()),
                                                 sdf.format(f.getDataNascimento().getTime()),
                                                 String.valueOf(f.getSalario())});
        }
    }
    
    public List<Funcionario> pesquisarWithFiltro(String filtroSelecionado, String valor) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
        switch(filtroSelecionado){
            case "Id":
                return this.getDaoFuncionario().listById(Long.parseLong(valor));
            case "CPF":
                return this.getDaoFuncionario().listByCpf(valor);
            case "Nome":
                return this.getDaoFuncionario().listByNome(valor);
            case "Cargo":
                return this.getDaoFuncionario().listByCargo(valor);
            case "Data Admissão":
                Calendar dataAdmissao = Calendar.getInstance();
                Date admDate = sdf.parse(valor);
                dataAdmissao.setTime(admDate);                
                return this.getDaoFuncionario().listByDataAdmissao(dataAdmissao);
            case "Data Nascimento":
                Calendar dataNascimento = Calendar.getInstance();
                Date nascDate = sdf.parse(valor);
                dataNascimento.setTime(nascDate);
                return this.getDaoFuncionario().listByDataNascimento(dataNascimento);
            case "Salário":
                return this.getDaoFuncionario().listBySalario(Double.parseDouble(valor));
        }
        return null;
    }
    
    public void limparPesquisa(){
        DefaultTableModel table = (DefaultTableModel) this.getView().getjTableFuncionarios().getModel();
        table.setRowCount(0);
    }
    
    //public Funcionario getFuncionarioSelecionado(){
        /*int linha = this.getView().getjTableFuncionarios().getSelectedRow();
        
        Long id = Long.parseLong(this.getTableFromScreen().getValueAt(linha, 0).toString());
        String edicao = this.getTableFromScreen().getValueAt(linha, 1).toString();
        String nomeAutor = this.getTableFromScreen().getValueAt(linha, 2).toString();
        String nomeEditora = this.getTableFromScreen().getValueAt(linha, 3).toString();
        int numPaginas = Integer.parseInt(this.getTableFromScreen().getValueAt(linha, 4).toString());
        String titulo = this.getTableFromScreen().getValueAt(linha, 5).toString();
        
        Funcionario f = new Funcionario(titulo, nomeAutor, nomeEditora, numPaginas, edicao);
        livro.setId(id);
        return livro;*/
    //}
    
}
