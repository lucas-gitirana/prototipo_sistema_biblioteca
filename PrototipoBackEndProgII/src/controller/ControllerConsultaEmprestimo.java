/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoEmprestimo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Emprestimo;
import view.JFConsultaEmprestimo;

/**
 *
 * @author gitir
 */
public class ControllerConsultaEmprestimo {
    
    private JFConsultaEmprestimo view;
    private DaoEmprestimo daoEmprestimo;

    public ControllerConsultaEmprestimo(JFConsultaEmprestimo view) {
        super();
        this.view = view;
        this.daoEmprestimo = new DaoEmprestimo();
    }

    public JFConsultaEmprestimo getView() {
        return view;
    }

    public void setView(JFConsultaEmprestimo view) {
        this.view = view;
    }

    public DaoEmprestimo getDaoEmprestimo() {
        return daoEmprestimo;
    }

    public void setDaoEmprestimo(DaoEmprestimo daoEmprestimo) {
        this.daoEmprestimo = daoEmprestimo;
    }
    
    public DefaultTableModel getTableFromScreen(){
        return (DefaultTableModel) this.view.getjTableEmprestimos().getModel();
    }
    
    public void pesquisar(){
        try {
            String filtroSelecionado = (String) this.getView().getJcbListaFiltros().getSelectedItem();
            List<Emprestimo> emprestimos = null;
            this.limparPesquisa();
            
            if(filtroSelecionado.isBlank() || this.getView().getJtPesquisa().getText().isBlank()){
                emprestimos = this.getDaoEmprestimo().listAll();
            } else {
                emprestimos = this.pesquisarWithFiltro(filtroSelecionado, this.getView().getJtPesquisa().getText());
            }
            
            if(emprestimos != null){
                this.imprimeValores(emprestimos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
    public void imprimeValores(List<Emprestimo> emprestimos){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(Emprestimo e : emprestimos){
            this.getTableFromScreen().addRow(new String[]{String.valueOf(e.getId()),
                                                 sdf.format(e.getDataEmprestimo().getTime()),
                                                 sdf.format(e.getDataDataDevolucaoEsperada().getTime()),
                                                 String.valueOf(e.getValorEmprestimo()),
                                                 String.valueOf(e.getMembro().getId()),
                                                 String.valueOf(e.getFuncionario().getId())
                                                 });
        }
    }
    
    
    public List<Emprestimo> pesquisarWithFiltro(String filtroSelecionado, String valor) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        switch(filtroSelecionado){
            case "Id":
                return this.getDaoEmprestimo().listById(Long.parseLong(valor));
            case "Data - Empréstimo":
                Calendar dataEmprestimo = Calendar.getInstance();
                Date empDate = sdf.parse(valor);
                dataEmprestimo.setTime(empDate);
                return this.getDaoEmprestimo().listByDataEmprestimo(dataEmprestimo);
            case "Data - Devolução Esperada":
                Calendar dataDevEsperada = Calendar.getInstance();
                Date devEspDate = sdf.parse(valor);
                dataDevEsperada.setTime(devEspDate);
                return this.getDaoEmprestimo().listByDataDevolucaoEsperada(dataDevEsperada);
            case "Data - Devolução Real":
                Calendar dataDevReal = Calendar.getInstance();
                Date devRealDate = sdf.parse(valor);
                dataDevReal.setTime(devRealDate);
                return this.getDaoEmprestimo().listByDataDevolucaoReal(dataDevReal);
            case "Valor":
                return this.getDaoEmprestimo().listByValor(Double.parseDouble(valor));
            case "Membro - Código":
                return this.getDaoEmprestimo().listByIdMembro(Integer.parseInt(valor));
            case "Funcionário - Código":
                return this.getDaoEmprestimo().listByIdFuncionario(Integer.parseInt(valor));
        }
        return null;
    }
    
    public void limparPesquisa(){
        this.getTableFromScreen().setRowCount(0);
    }
    
    public Emprestimo getEmprestimoSelecionado(){
        try {
            int linha = this.getView().getjTableEmprestimos().getSelectedRow();
            Long id = Long.parseLong(this.getTableFromScreen().getValueAt(linha, 0).toString());
            return this.getDaoEmprestimo().list(id);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this.getView(), "Não foi possível carregar o empréstimo. Erro: "+e.getMessage());
            return null;
        }
    }
}
