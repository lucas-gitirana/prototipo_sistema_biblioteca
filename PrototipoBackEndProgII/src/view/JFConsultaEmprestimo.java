/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerConsultaEmprestimo;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author gitir
 */
public class JFConsultaEmprestimo extends javax.swing.JFrame {
    
    private ControllerConsultaEmprestimo controller;

    /**
     * Creates new form JFConsultaEmprestimo
     */
    public JFConsultaEmprestimo() {
        this.controller = new ControllerConsultaEmprestimo(this);
        initComponents();
        
        jTableEmprestimos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // Verifica se há alguma linha selecionada
                if (!e.getValueIsAdjusting() && jTableEmprestimos.getSelectedRow() != -1) {
                    // Habilita o botão porque há uma linha selecionada
                    jbAlterar.setEnabled(true);
                    jbExcluir.setEnabled(true);
                    jbDevolver.setEnabled(true);
                    jbUnidades.setEnabled(true);
                    jbDesatualizar.setEnabled(true);
                } else {
                    // Desabilita o botão porque nenhuma linha está selecionada
                    jbAlterar.setEnabled(false);
                    jbExcluir.setEnabled(false);
                    jbDevolver.setEnabled(false);
                    jbUnidades.setEnabled(false);
                    jbDesatualizar.setEnabled(false);
                }
            }
        });
    }

    public ControllerConsultaEmprestimo getController() {
        return controller;
    }

    public void setController(ControllerConsultaEmprestimo controller) {
        this.controller = controller;
    }

    public JTable getjTableEmprestimos() {
        return jTableEmprestimos;
    }

    public void setjTableEmprestimos(JTable jTableEmprestimos) {
        this.jTableEmprestimos = jTableEmprestimos;
    }

    public JButton getJbAlterar() {
        return jbAlterar;
    }

    public void setJbAlterar(JButton jbAlterar) {
        this.jbAlterar = jbAlterar;
    }

    public JButton getJbExcluir() {
        return jbExcluir;
    }

    public void setJbExcluir(JButton jbExcluir) {
        this.jbExcluir = jbExcluir;
    }

    public JComboBox<String> getJcbListaFiltros() {
        return jcbListaFiltros;
    }

    public void setJcbListaFiltros(JComboBox<String> jcbListaFiltros) {
        this.jcbListaFiltros = jcbListaFiltros;
    }

    public JTextField getJtPesquisa() {
        return jtPesquisa;
    }

    public void setJtPesquisa(JTextField jtPesquisa) {
        this.jtPesquisa = jtPesquisa;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtPesquisa = new javax.swing.JTextField();
        jBPesquisar = new javax.swing.JButton();
        jcbListaFiltros = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmprestimos = new javax.swing.JTable();
        jbIncluir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbDevolver = new javax.swing.JButton();
        jbUnidades = new javax.swing.JButton();
        jbDesatualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtPesquisa.setMargin(new java.awt.Insets(0, 6, 0, 6));
        jtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPesquisaActionPerformed(evt);
            }
        });

        jBPesquisar.setText("Buscar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jcbListaFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Data - Empréstimo", "Data - Devolução Esperada", "Valor", "Membro - Código", "Funcionário - Código", "Data - Devolução Real" }));
        jcbListaFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbListaFiltrosActionPerformed(evt);
            }
        });

        jTableEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Empréstimo", "Dev. Esperada", "Valor", "Membro", "Funcionário", "Dev. Real"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableEmprestimos);

        jbIncluir.setText("Incluir");
        jbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIncluirActionPerformed(evt);
            }
        });

        jbAlterar.setText("Alterar");
        jbAlterar.setEnabled(false);
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Consultar Empréstimos");

        jbDevolver.setText("Devolver");
        jbDevolver.setToolTipText("");
        jbDevolver.setEnabled(false);
        jbDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDevolverActionPerformed(evt);
            }
        });

        jbUnidades.setText("Unidades");
        jbUnidades.setEnabled(false);
        jbUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUnidadesActionPerformed(evt);
            }
        });

        jbDesatualizar.setText("Desatualizar");
        jbDesatualizar.setToolTipText("");
        jbDesatualizar.setEnabled(false);
        jbDesatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDesatualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbUnidades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDevolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDesatualizar)
                        .addGap(39, 39, 39)
                        .addComponent(jbIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jcbListaFiltros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBPesquisar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar)
                    .addComponent(jcbListaFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcluir)
                    .addComponent(jbAlterar)
                    .addComponent(jbIncluir)
                    .addComponent(jbDevolver)
                    .addComponent(jbUnidades)
                    .addComponent(jbDesatualizar))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPesquisaActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        this.getController().pesquisar();
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jcbListaFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbListaFiltrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbListaFiltrosActionPerformed

    private void jbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIncluirActionPerformed
        JFManutencaoEmprestimo manutencaoEmprestimo  = new JFManutencaoEmprestimo();
        manutencaoEmprestimo.setVisible(true);
    }//GEN-LAST:event_jbIncluirActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        JFManutencaoEmprestimo manEmprestimo = new JFManutencaoEmprestimo();
        manEmprestimo.getController().setEmprestimo(this.getController().getEmprestimoSelecionado());
        manEmprestimo.setVisible(true);
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDevolverActionPerformed
        if(this.getController().getEmprestimoSelecionado().getUnidades().size() >= 1){
            JFManutencaoDevolverEmprestimo view = new JFManutencaoDevolverEmprestimo();
            view.getController().setEmprestimo(this.getController().getEmprestimoSelecionado());
            view.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Este empréstimo não tem unidades.");
        }        
    }//GEN-LAST:event_jbDevolverActionPerformed

    private void jbUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUnidadesActionPerformed
        JFConsultaUnidadeEmprestimo unidadeEmprestimo = new JFConsultaUnidadeEmprestimo();
        unidadeEmprestimo.getController().setEmprestimo(this.getController().getEmprestimoSelecionado());
        unidadeEmprestimo.setVisible(true);     
    }//GEN-LAST:event_jbUnidadesActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.getController().pesquisar();
    }//GEN-LAST:event_formWindowOpened

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        JFManutencaoEmprestimo manEmprestimo = new JFManutencaoEmprestimo();
        manEmprestimo.getController().setEmprestimo(this.getController().getEmprestimoSelecionado());
        manEmprestimo.getController().excluirEmprestimo();
        this.getController().pesquisar();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbDesatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDesatualizarActionPerformed
        if(this.getController().getEmprestimoSelecionado().getDataDevolucaoReal() == null){
            JOptionPane.showMessageDialog(rootPane, "Este empréstimo ainda não foi devolvido.");
        } else {
            JFManutencaoDevolverEmprestimo view = new JFManutencaoDevolverEmprestimo();
            view.getController().desatualizarEmprestimo(this.getController().getEmprestimoSelecionado());
            this.getController().pesquisar();
        }
    }//GEN-LAST:event_jbDesatualizarActionPerformed

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
            java.util.logging.Logger.getLogger(JFConsultaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFConsultaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFConsultaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFConsultaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFConsultaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmprestimos;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbDesatualizar;
    private javax.swing.JButton jbDevolver;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbIncluir;
    private javax.swing.JButton jbUnidades;
    private javax.swing.JComboBox<String> jcbListaFiltros;
    private javax.swing.JTextField jtPesquisa;
    // End of variables declaration//GEN-END:variables
}
