/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UTB.presentacion;

import com.UTB.funcion.Function;
import com.UTB.metodos.FalsePosition;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.ParseException;

/**
 *
 * @author Cess
 */
public class JFRMetodoFalsaPosicion extends javax.swing.JInternalFrame {

    /**
     * Creates new form JFRMetodoFalsePosition
     */
    ColorTable color;

    public JFRMetodoFalsaPosicion() {
        initComponents();
        this.tbResultado.setDefaultRenderer(Object.class, new ColorTable());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void clear() {
        this.txtFunction.setText("");
        this.txtIntervalA.setText("");
        this.txtIntervalB.setText("");
        this.txtIteractions.setText("");
        this.txtExactRoot.setText("");
        this.txtErr.setText("");
        DefaultTableModel a = (DefaultTableModel) tbResultado.getModel();
        while (a.getRowCount() > 0) {
            a.removeRow(0);
        }
    }

    public void clearTable() {
        DefaultTableModel a = (DefaultTableModel) tbResultado.getModel();
        while (a.getRowCount() > 0) {
            a.removeRow(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFunction = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIntervalA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIntervalB = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtErr = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIteractions = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        btnCalc = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        comboOption = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtExactRoot = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboYesOrNot = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);

        jDesktopPane1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SOLUCION DE ECUACIONES NO LINEALES - METODO FALSA POSICION");

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel2.setText("FUNCION");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel3.setText("Punto a: ");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel4.setText("Punto b: ");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel5.setText("Error: ");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel6.setText("Número de Iteraciones");

        txtIteractions.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TABLA DE RESULTADOS");

        tbResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbResultado);

        btnCalc.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        btnCalc.setText("Calcular");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        btnClean.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        btnClean.setText("Borrar");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel8.setText("Calcular error mediante: ");

        comboOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione una opcion-", "1. |b-a|", "2. |xi-xi-1|", "3. |xi-√ x|" }));
        comboOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOptionActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel9.setText("Raiz Exacta: ");

        txtExactRoot.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel10.setText("Conoce la raiz exacta? ");

        comboYesOrNot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione una opcion-", "1. SI", "2. NO" }));
        comboYesOrNot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYesOrNotActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtFunction, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtIntervalA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtIntervalB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtErr, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtIteractions, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCalc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnClean, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboOption, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtExactRoot, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(comboYesOrNot, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap(313, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboYesOrNot, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboOption, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIntervalA, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIteractions, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtExactRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                                .addComponent(txtIntervalB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtErr, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(48, 48, 48)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFunction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(2, 2, 2)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIntervalA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtIntervalB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtErr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(comboYesOrNot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtExactRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtIteractions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        try {
            if (!this.txtFunction.getText().isEmpty()
                    && !(this.txtIntervalA.getText().isEmpty())
                    && !(this.txtIntervalB.getText().isEmpty())
                    && !(this.txtErr.getText().isEmpty())
                    || !(this.txtIteractions.getText().isEmpty())
                    || !(this.txtExactRoot.getText().isEmpty())) {
                DJep j = new DJep();
                j.addStandardConstants();
                j.addStandardFunctions();
                j.parseExpression(this.txtIntervalA.getText());
                double IA = j.getValue();
                j.parseExpression(this.txtIntervalB.getText());
                double IB = j.getValue();
                j.parseExpression(this.txtErr.getText());
                double err = j.getValue();
                j.parseExpression(this.txtExactRoot.getText());
                double raiz = j.getValue();
                switch (this.comboOption.getSelectedIndex()) {
                    case 1:
                        if (!this.txtIteractions.getText().isEmpty()) {
                            int i = Integer.parseInt(this.txtIteractions.getText());
                            Function funcion = new Function(this.txtFunction.getText());
                            FalsePosition falsePosition = new FalsePosition();
                            tbResultado.getModel();
                            try {
                                if (falsePosition.check(funcion, IA, IB)) {
                                    falsePosition.calcFalsePositionByIntervals(tbResultado, funcion, IA, IB, err, i);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No existe ninguna raíz con los puntos dados", "Verificación", 1);
                                    clearTable();
                                }
                            } catch (ParseException ex) {
                                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error. Especifique el maximo de iteraciones");
                        }
                        break;
                    case 2:
                        if (!this.txtIteractions.getText().isEmpty()) {
                            int i = Integer.parseInt(this.txtIteractions.getText());
                            Function funcion = new Function(this.txtFunction.getText());
                            FalsePosition falsePosition = new FalsePosition();
                            tbResultado.getModel();
                            try {
                                if (falsePosition.check(funcion, IA, IB)) {
                                    falsePosition.calcFalsePositionByXi(tbResultado, funcion, IA, IB, err, i);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No existe ninguna raíz con los puntos dados", "Verificación", 1);
                                    clearTable();
                                }
                            } catch (ParseException ex) {
                                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error. Especifique el maximo de iteraciones");
                        }
                        break;
                    case 3:
                        if (!this.txtExactRoot.getText().isEmpty()) {
                            Function funcion = new Function(this.txtFunction.getText());
                            FalsePosition falsePosition = new FalsePosition();
                            tbResultado.getModel();
                            try {
                                if (falsePosition.check(funcion, IA, IB)) {
                                    falsePosition.calcByExactRoot(tbResultado, funcion, IA, IB, err, raiz);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No existe ninguna raíz con los puntos dados", "Verificación", 1);
                                    clearTable();
                                }
                            } catch (ParseException ex) {
                                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error. Especifique el maximo de iteraciones");
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Seleccione una opcion para calcular el error");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Hay uno o varios campos vacios", "No se pudo calcular", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCalcActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        clear();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void comboOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOptionActionPerformed
        if (this.comboYesOrNot.getSelectedIndex() != 0) {
            if (this.comboYesOrNot.getSelectedIndex() == 1) {
                if (this.comboOption.getSelectedIndex() != 3) {
                    JOptionPane.showMessageDialog(null, "No se puede calcular el error con esa opcion");
                    this.comboOption.setSelectedIndex(3);
                }
            }
            if (this.comboYesOrNot.getSelectedIndex() == 2) {
                if (this.comboOption.getSelectedIndex() == 3) {
                    JOptionPane.showMessageDialog(null, "No se puede calcular el error con esa opcion");
                    this.comboOption.setSelectedIndex(0);
                    this.txtIteractions.setText("");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe responder si conoce la raiz exacta");
            this.comboOption.setSelectedIndex(0);
        }
    }//GEN-LAST:event_comboOptionActionPerformed

    private void comboYesOrNotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYesOrNotActionPerformed
        if (!this.txtFunction.getText().isEmpty()
                && !(this.txtIntervalA.getText().isEmpty())
                && !(this.txtIntervalB.getText().isEmpty())
                && !(this.txtErr.getText().isEmpty())) {
            switch (this.comboYesOrNot.getSelectedIndex()) {
                case 1:
                    this.jLabel9.setVisible(true);
                    this.txtExactRoot.setVisible(true);
                    this.txtExactRoot.setEnabled(true);
                    this.txtIteractions.setText("");
                    this.jLabel6.setVisible(false);
                    this.txtIteractions.setVisible(false);
                    this.txtIteractions.setEnabled(false);
                    this.comboOption.setSelectedIndex(3);
                    break;
                case 2:
                    this.jLabel6.setVisible(true);
                    this.txtIteractions.setVisible(true);
                    this.txtIteractions.setEnabled(true);
                    this.txtExactRoot.setText("");
                    this.jLabel9.setVisible(false);
                    this.txtExactRoot.setVisible(false);
                    this.txtExactRoot.setEnabled(false);
                    this.comboOption.setSelectedIndex(0);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene los campos requeridos");
            this.comboYesOrNot.setSelectedIndex(0);
        }
    }//GEN-LAST:event_comboYesOrNotActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc;
    private javax.swing.JButton btnClean;
    private javax.swing.JComboBox<String> comboOption;
    private javax.swing.JComboBox<String> comboYesOrNot;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbResultado;
    private javax.swing.JTextField txtErr;
    private javax.swing.JTextField txtExactRoot;
    private javax.swing.JTextField txtFunction;
    private javax.swing.JTextField txtIntervalA;
    private javax.swing.JTextField txtIntervalB;
    private javax.swing.JTextField txtIteractions;
    // End of variables declaration//GEN-END:variables
}
