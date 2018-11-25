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
public class NewtonRaphson {

    public boolean check(Function f, double interval) throws ParseException {
        boolean root = false;
        double Fix = 0;
        String derivada = null;
        try {
            derivada = f.Derivate();
            Function f2 = new Function(derivada);
            Fix = f2.eval(interval);
            if (Fix != 0) {
                root = true;
            } else {
                root = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return root;
    }

    public void calcNewtonRaphson(JTable table, Function fx, double interval, double error, int i) throws Exception {
        try {
            int cont = 1;
            double Fxi = 0;
            String derivada = null;
            double Fix = 0;
            double errorResult = 0;
            double x2 = 0;
            double xAnt = 0;
            String a4 = null;
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "xi", "F(xi)", "F'(xi)", "Error"};
            model = new DefaultTableModel(datos, nombre_columnas) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            table.setModel(model);
            double xi = interval;
            for (int j = i; j >= 1; j--) {
                xAnt = xi;
                derivada = fx.Derivate();
                Function f2 = new Function(derivada);
                Fxi = fx.eval(xi);
                Fix = f2.eval(xi);
                x2 = -((Fxi) / (Fix));
                xi = xi + (x2);
                errorResult = Math.abs(xi - xAnt);
                a4 = String.format("%20f", errorResult);
                if (errorResult >= error) {
                    Object[] fila = {
                        cont,
                        xAnt,
                        Fxi,
                        Fix,
                        a4
                    };
                    model.addRow(fila);
                    cont++;
                } else {
                    break;
                }
            }
            JOptionPane.showMessageDialog(
                    null, "La raíz es: " + xAnt + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
                    "MENSAJE", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en metodo: " + e.getMessage());
        }

    }
}
