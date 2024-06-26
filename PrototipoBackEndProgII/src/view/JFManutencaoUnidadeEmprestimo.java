/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerManutencaoUnidadeEmprestimo;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author gitir
 */
public class JFManutencaoUnidadeEmprestimo extends javax.swing.JFrame {
    
    ControllerManutencaoUnidadeEmprestimo controller;

    /**
     * Creates new form JFManutencaoUnidadeEmprestimo
     */
    public JFManutencaoUnidadeEmprestimo() {
        this.controller = new ControllerManutencaoUnidadeEmprestimo(this);
        initComponents();
    }

    public ControllerManutencaoUnidadeEmprestimo getController() {
        return controller;
    }

    public void setController(ControllerManutencaoUnidadeEmprestimo controller) {
        this.controller = controller;
    }

    public JButton getjBConsUnidade() {
        return jBConsUnidade;
    }

    public void setjBConsUnidade(JButton jBConsUnidade) {
        this.jBConsUnidade = jBConsUnidade;
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

    public JTextField getjTIdEmprestimo() {
        return jTIdEmprestimo;
    }

    public void setjTIdEmprestimo(JTextField jTIdEmprestimo) {
        this.jTIdEmprestimo = jTIdEmprestimo;
    }

    public JTextField getjTIdUnidade() {
        return jTIdUnidade;
    }

    public void setjTIdUnidade(JTextField jTIdUnidade) {
        this.jTIdUnidade = jTIdUnidade;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTIdUnidade = new javax.swing.JTextField();
        jLTituloPagina = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTIdEmprestimo = new javax.swing.JTextField();
        jBGravar = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jBConsUnidade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLTituloPagina.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLTituloPagina.setText("Adicionar Unidade do Empréstimo");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Empréstimo - Id");

        jTIdEmprestimo.setEnabled(false);

        jBGravar.setText("Gravar");
        jBGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarActionPerformed(evt);
            }
        });

        jBLimpar.setText("Limpar");
        jBLimpar.setToolTipText("");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Unidade - Id");

        jBConsUnidade.setText("Consultar");
        jBConsUnidade.setToolTipText("");
        jBConsUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsUnidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLTituloPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTIdEmprestimo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTIdUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBConsUnidade))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBGravar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTituloPagina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTIdEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTIdUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jBConsUnidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLimpar)
                    .addComponent(jBGravar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed
        String validaCampos = this.validaCampos();
        if(!validaCampos.isBlank()){
            JOptionPane.showMessageDialog(rootPane, validaCampos);
        } else {
            this.getController().addUnidade();
        }
    }//GEN-LAST:event_jBGravarActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        jTIdUnidade.setText("");
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jBConsUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsUnidadeActionPerformed
        JFConsultaUnidade consUnidade = new JFConsultaUnidade();
        consUnidade.setVisible(true);
    }//GEN-LAST:event_jBConsUnidadeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(this.getController().getEmprestimo() != null){
            jTIdEmprestimo.setText(String.valueOf(this.getController().getEmprestimo().getId()));
        }
    }//GEN-LAST:event_formWindowOpened

    private String validaCampos(){
        String msg = "";
        if(jTIdUnidade.getText().isBlank()){
            msg += "\n- O campo Unidade - Id não pode ser vazio!";
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
            java.util.logging.Logger.getLogger(JFManutencaoUnidadeEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFManutencaoUnidadeEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFManutencaoUnidadeEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFManutencaoUnidadeEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFManutencaoUnidadeEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConsUnidade;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JLabel jLTituloPagina;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTIdEmprestimo;
    private javax.swing.JTextField jTIdUnidade;
    // End of variables declaration//GEN-END:variables
}
