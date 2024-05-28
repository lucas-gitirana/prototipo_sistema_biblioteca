/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prototipobackendprogii;

import dao.DaoEmprestimo;
import dao.DaoFuncionario;
import dao.DaoLivro;
import dao.DaoMembro;
import dao.DaoUnidade;
import java.util.Calendar;
import model.Emprestimo;
import model.Funcionario;
import model.Livro;
import model.Membro;
import model.Unidade;

/**
 *
 * @author gitir
 */
public class PrototipoBackEndProgII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoLivro daoLivro = new DaoLivro();
        
        //INSERT
        Livro l = new Livro("Teste","Lucas","Editora X",160,"Versão 1");
        daoLivro.insert(l);
        
        Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, 2024);
        data.set(Calendar.MONTH, Calendar.MAY); // Janeiro é 0, Fevereiro é 1, ..., Dezembro é 11
        data.set(Calendar.DAY_OF_MONTH, 25);
        
        Unidade u = new Unidade('D', data, daoLivro.list(1l));
        DaoUnidade daoUnidade = new DaoUnidade();
        daoUnidade.insert(u);
        
        //GET UM
        //System.out.println(daoLivro.list(201l).getEdicao());
        
        //GET TODOS
        /*for(Livro l : daoLivro.listAll()){
            System.out.println(l.getId());
        }*/
        
        //EDITAR
        /*Livro l = daoLivro.list(201l);
        l.setEdicao("V. 2.0");
        daoLivro.update(l);*/
        
        //EXCLUIR
        /*Livro l = daoLivro.list(201l);
        daoLivro.delete(l);*/
        
        /*Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, 2024);
        data.set(Calendar.MONTH, Calendar.MAY); // Janeiro é 0, Fevereiro é 1, ..., Dezembro é 11
        data.set(Calendar.DAY_OF_MONTH, 25);*/
        
        Membro m = new Membro("049695200-54", "Lucas", data, data, 'P', 'E');
        DaoMembro dm = new DaoMembro();
        dm.insert(m);
        
        Funcionario f = new Funcionario("090909090", "Lucas", data, "bibliotecário", data, 1200.98);
        DaoFuncionario df = new DaoFuncionario();
        df.insert(f);
        
        Emprestimo e = new Emprestimo(data, data, data, 25, m, f);
        e.addUnidade(u);
        DaoEmprestimo de = new DaoEmprestimo();
        de.insert(e);
        
        
    }
    
}
