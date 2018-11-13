/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UTB.metodos;

import com.UTB.funcion.Function;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.nfunk.jep.ParseException;

/**
 *
 * @author Cess
 */
public class Bisection {

    public void check(Function f, double intervalA, double intervalB) throws ParseException {
        try {
            double Fa = 0;
            double Fb = 0;
            Fa = f.eval(intervalA);
            Fb = f.eval(intervalB);
            if (Fa * Fb <= 0) {
                JOptionPane.showMessageDialog(null, "Existe al menos una Raíz", "Verificación", 1);
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna raíz", "Verificación", 1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void calcsInteractions(JTable table, Function fx, double intervalA, double intervalB, double error, int i) {
        try {
            int cont = 1;
            double Xk = 0;
            double Fa = 0;
            double Fb = 0;
            double fXk = 0;
            double errorResult = 0;

            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "a", "b", "Xi", "f(a)", "f(b)", "f(Xi)", "Error"};
            model = new DefaultTableModel(datos, nombre_columnas) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            table.setModel(model);

            errorResult = Math.abs(intervalB - intervalA);
            while (errorResult >= error && cont <= i) {
                Xk = (intervalA + intervalB) / 2;
                Fa = fx.eval(intervalA);
                fXk = fx.eval(Xk);
                Fb = fx.eval(intervalB);
                errorResult = Math.abs(intervalB - intervalA);//devuelve el valor absoluto del error
                Object[] row
                        = {
                            cont,
                            intervalA,
                            intervalB,
                            Xk,
                            Fa,
                            Fb,
                            fXk,
                            errorResult};
                if (fXk * Fa <= 0) {
                    intervalB = Xk;
                } else {
                    intervalA = Xk;
                }
                model.addRow(row);
                cont++;

            }
            JOptionPane.showMessageDialog(
                    null, "La raíz es: " + Xk + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
                    "MENSAJE", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el metodo: " + e.getMessage());
        }
    }
}
