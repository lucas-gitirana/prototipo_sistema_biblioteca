/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerConsultaLivro;
import controller.ControllerManutencaoMembro;
import dao.DaoLivro;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Livro;

/**
 *
 * @author leonardo gaertner
 */
public class JFCadastroCliente extends javax.swing.JFrame {
    
    ControllerManutencaoMembro controller;

    /**
     * Creates new form JFCadastroLivro
     */
    public JFCadastroCliente() {
        this.controller = new ControllerManutencaoMembro(this);
        initComponents();
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

    public JTextField getjTCadastro() {
        return jTCadastro;
    }

    public void setjTCadastro(JTextField jTCadastro) {
        this.jTCadastro = jTCadastro;
    }

    public JTextField getjTCpf() {
        return jTCpf;
    }

    public void setjTCpf(JTextField jTCpf) {
        this.jTCpf = jTCpf;
    }

    public JTextField getjTId() {
        return jTId;
    }

    public void setjTId(JTextField jTId) {
        this.jTId = jTId;
    }

    public JTextField getjTNascimento() {
        return jTNascimento;
    }

    public void setjTNascimento(JTextField jTNascimento) {
        this.jTNascimento = jTNascimento;
    }

    public JTextField getjTNome() {
        return jTNome;
    }

    public void setjTNome(JTextField jTNome) {
        this.jTNome = jTNome;
    }

    public JComboBox<String> getjCBPlano() {
        return jCBPlano;
    }

    public void setjCBPlano(JComboBox<String> jCBPlano) {
        this.jCBPlano = jCBPlano;
    }

    public JComboBox<String> getjCBStatus() {
        return jCBStatus;
    }

    public void setjCBStatus(JComboBox<String> jCBStatus) {
        this.jCBStatus = jCBStatus;
    }
    
    public ControllerManutencaoMembro getController() {
        return controller;
    }

    public void setController(ControllerManutencaoMembro controller) {
        this.controller = controller;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jTCpf = new javax.swing.JTextField();
        jTNascimento = new javax.swing.JTextField();
        jTCadastro = new javax.swing.JTextField();
        jBGravar = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jCBPlano = new javax.swing.JComboBox<>();
        jCBStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTTitulo.setText("Cadastrar Cliente");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Id");

        jTId.setEnabled(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CPF");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nome");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data Nasimento");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Data Cadastro");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Plano");

        jTNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomeActionPerformed(evt);
            }
        });

        jTCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCpfActionPerformed(evt);
            }
        });

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

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Status");

        jCBPlano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Básico", "Premium" }));

        jCBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBGravar))
                    .addComponent(jTTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTNascimento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTCpf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTCadastro)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCBPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 161, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTTitulo)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGravar)
                    .addComponent(jBLimpar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfActionPerformed

    private void jTNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeActionPerformed

    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed
        String validaCampos = this.validaCampos();
        if(!validaCampos.isBlank()){
            JOptionPane.showMessageDialog(rootPane, validaCampos);
        } else {
            this.getController().gravarMembro();
        } 
    }//GEN-LAST:event_jBGravarActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
       jTCpf.setText("");
       jTNome.setText("");
       jTNascimento.setText("");
       jTCadastro.setText("");
       jCBPlano.setSelectedIndex(0);
       jCBStatus.setSelectedIndex(0);
    }//GEN-LAST:event_jBLimparActionPerformed

    private String validaCampos(){
        String msg = "";
        if(jTCpf.getText().isBlank()){
            msg += "\n- O campo CPF não pode ser vazio!";
        }
        if(jTNome.getText().isBlank()){
            msg += "\n- O campo Nome não pode ser vazio!";
        }
        if(jTNascimento.getText().isBlank()){
            msg += "\n- O campo Cargo não pode ser vazio!";
        }
        if(jTCadastro.getText().isBlank()){
            msg += "\n- O campo Admissão não pode ser vazio!";
        }
        if(this.getController().getPlano() == 0){
            msg += "\n- O campo Plano é inválido!";
        }
        if(this.getController().getStatus() == 0){
            msg += "\n- O campo Status é inválido!";
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
            java.util.logging.Logger.getLogger(JFCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JComboBox<String> jCBPlano;
    private javax.swing.JComboBox<String> jCBStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTCadastro;
    private javax.swing.JTextField jTCpf;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTNascimento;
    private javax.swing.JTextField jTNome;
    private javax.swing.JLabel jTTitulo;
    // End of variables declaration//GEN-END:variables
}
