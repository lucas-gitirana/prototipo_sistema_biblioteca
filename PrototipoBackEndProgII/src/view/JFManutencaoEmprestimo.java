/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerManutencaoEmprestimo;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author gitir
 */
public class JFManutencaoEmprestimo extends javax.swing.JFrame {
    
    private ControllerManutencaoEmprestimo controller;

    /**
     * Creates new form JFManutencaoEmprestimo
     */
    public JFManutencaoEmprestimo() {
        this.controller = new ControllerManutencaoEmprestimo(this);
        initComponents();
    }

    public ControllerManutencaoEmprestimo getController() {
        return controller;
    }

    public void setController(ControllerManutencaoEmprestimo controller) {
        this.controller = controller;
    }

    public JButton getjBConsCliente() {
        return jBConsCliente;
    }

    public void setjBConsCliente(JButton jBConsCliente) {
        this.jBConsCliente = jBConsCliente;
    }

    public JButton getjBConsFuncionario() {
        return jBConsFuncionario;
    }

    public void setjBConsFuncionario(JButton jBConsFuncionario) {
        this.jBConsFuncionario = jBConsFuncionario;
    }

    public JButton getjBGravar() {
        return jBGravar;
    }

    public void setjBGravar(JButton jBGravar) {
        this.jBGravar = jBGravar;
    }

    public JButton getjBLimpar() {
        return jBLimpar;
    }

    public void setjBLimpar(JButton jBLimpar) {
        this.jBLimpar = jBLimpar;
    }

    public JTextField getjTDataDevolucao() {
        return jTDataDevolucao;
    }

    public void setjTDataDevolucao(JTextField jTDataDevolucao) {
        this.jTDataDevolucao = jTDataDevolucao;
    }

    public JTextField getjTDataEmprestimo() {
        return jTDataEmprestimo;
    }

    public void setjTDataEmprestimo(JTextField jTDataEmprestimo) {
        this.jTDataEmprestimo = jTDataEmprestimo;
    }

    public JTextField getjTId() {
        return jTId;
    }

    public void setjTId(JTextField jTId) {
        this.jTId = jTId;
    }

    public JTextField getjTIdCliente() {
        return jTIdCliente;
    }

    public void setjTIdCliente(JTextField jTIdCliente) {
        this.jTIdCliente = jTIdCliente;
    }

    public JTextField getjTIdFuncionario() {
        return jTIdFuncionario;
    }

    public void setjTIdFuncionario(JTextField jTIdFuncionario) {
        this.jTIdFuncionario = jTIdFuncionario;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTDataDevolucao = new javax.swing.JTextField();
        jTDataEmprestimo = new javax.swing.JTextField();
        jLTituloPagina = new javax.swing.JLabel();
        jTIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTIdFuncionario = new javax.swing.JTextField();
        jTId = new javax.swing.JTextField();
        jBGravar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBLimpar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jBConsCliente = new javax.swing.JButton();
        jBConsFuncionario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Cliente");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Funcionário");

        jTDataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDataDevolucaoActionPerformed(evt);
            }
        });

        jTDataEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDataEmprestimoActionPerformed(evt);
            }
        });

        jLTituloPagina.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLTituloPagina.setText("Cadastrar Empréstimo");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Id");

        jTId.setEnabled(false);

        jBGravar.setText("Gravar");
        jBGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Data - Empréstimo");

        jBLimpar.setText("Limpar");
        jBLimpar.setToolTipText("");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Data - Devolução");

        jBConsCliente.setText("Consultar");
        jBConsCliente.setToolTipText("");
        jBConsCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsClienteActionPerformed(evt);
            }
        });

        jBConsFuncionario.setText("Consultar");
        jBConsFuncionario.setToolTipText("");
        jBConsFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLTituloPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 13, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTDataEmprestimo)
                            .addComponent(jTDataDevolucao)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBGravar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBConsFuncionario)
                                    .addComponent(jBConsCliente)))
                            .addComponent(jTId))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTituloPagina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBConsCliente)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBConsFuncionario)
                    .addComponent(jTIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGravar)
                    .addComponent(jBLimpar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDataDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataDevolucaoActionPerformed

    private void jTDataEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDataEmprestimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataEmprestimoActionPerformed

    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed
        String validaCampos = this.validaCampos();
        if(!validaCampos.isBlank()){
            JOptionPane.showMessageDialog(rootPane, validaCampos);
        } else {
            if(this.getController().getEmprestimo()!= null){
                this.getController().alterarEmprestimo();
            } else {
                this.getController().gravarEmprestimo();
            }
        }
    }//GEN-LAST:event_jBGravarActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        jTDataDevolucao.setText("");
        jTDataEmprestimo.setText("");
        jTIdCliente.setText("");
        jTIdFuncionario.setText("");
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jBConsClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsClienteActionPerformed
        JFConsultaCliente consultaCliente = new JFConsultaCliente();
        consultaCliente.setVisible(true);
    }//GEN-LAST:event_jBConsClienteActionPerformed

    private void jBConsFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsFuncionarioActionPerformed
        JFConsultaFuncionario consultaFuncionario = new JFConsultaFuncionario();
        consultaFuncionario.setVisible(true);
    }//GEN-LAST:event_jBConsFuncionarioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(this.getController().getEmprestimo() != null){
            jTId.setText(String.valueOf(this.getController().getEmprestimo().getId()));
            jTIdCliente.setText(String.valueOf(this.getController().getEmprestimo().getMembro().getId()));
            jTIdFuncionario.setText(String.valueOf(this.getController().getEmprestimo().getFuncionario().getId()));
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            jTDataDevolucao.setText(sdf.format(this.getController().getEmprestimo().getDataDataDevolucaoEsperada().getTime()));
            jTDataEmprestimo.setText(sdf.format(this.getController().getEmprestimo().getDataEmprestimo().getTime()));
            jLTituloPagina.setText("Alterar Empréstimo");
        }
    }//GEN-LAST:event_formWindowOpened

    private String validaCampos(){
        String msg = "";
        if(jTId.getText().isBlank()){
            //msg += "\n O campo Edição não pode ser vazio!";
        }
        if(jTIdCliente.getText().isBlank()){
            msg += "\n- O campo Cliente não pode ser vazio!";
        }
        if(jTDataDevolucao.getText().isBlank()){
            msg += "\n- O campo Data - Devolução não pode ser vazio!";
        } 
        if(jTDataEmprestimo.getText().isBlank()){
            msg += "\n- O campo Data - Empréstimo não pode ser vazio!";
        }
        if(jTIdFuncionario.getText().isBlank()){
            msg += "\n- O campo Funcionário não pode ser vazio!";
        }
        return msg;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFManutencaoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFManutencaoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFManutencaoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFManutencaoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFManutencaoEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConsCliente;
    private javax.swing.JButton jBConsFuncionario;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JLabel jLTituloPagina;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTDataDevolucao;
    private javax.swing.JTextField jTDataEmprestimo;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTIdCliente;
    private javax.swing.JTextField jTIdFuncionario;
    // End of variables declaration//GEN-END:variables
}
