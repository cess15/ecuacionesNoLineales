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
        String derivada = f.Derivate();
        Function f2 = new Function(derivada);
        double Fix = f2.eval(interval);
        return Fix == 0;
    }

    public void calcNewtonRaphsonByXi(JTable table, Function fx, double interval, double error, int i) throws Exception {
        try {
            int cont = 1;
            double Fxi = 0;
            String derivada = null;
            double Fix = 0;
            double errorResult = 0;
            double x2 = 0;
            double xAnt = 0;
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "xi", "F(xi)=" + fx.getF(), "F'(xi)=" + fx.Derivate(), "Error"};
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
                Object[] fila = {
                    cont,
                    String.format("%10f", xAnt),
                    String.format("%10f", Fxi),
                    String.format("%10f", Fix),
                    String.format("%20f", errorResult)
                };
                model.addRow(fila);
                cont++;
                if (errorResult <= error) {
                    break;
                }
            }
            JOptionPane.showMessageDialog(
                    null, "La raíz es: " + String.format("%10f", xAnt) + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
                    "MENSAJE", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en metodo Newton: " + e.getMessage());
        }

    }

    public void calcNewtonRaphsonByRoot(JTable table, Function fx, double interval, double error, double raiz) throws Exception {
        try {
            int cont = 1;
            double Fxi = 0;
            String derivada = null;
            double Fix = 0;
            double errorResult = 0;
            double x2 = 0;
            double eva = 0;
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "xi", "F(xi)=" + fx.getF(), "F'(xi)=" + fx.Derivate(), "Error"};
            model = new DefaultTableModel(datos, nombre_columnas) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            table.setModel(model);
            errorResult = Math.abs(raiz - interval);
            eva = fx.eval(raiz);
            if (eva == 0) {
                while (errorResult >= error) {
                    Fxi = fx.eval(interval);
                    errorResult = Math.abs(raiz - interval);
                    Object[] fila = {
                        cont,
                        String.format("%10f", interval),
                        String.format("%10f", Fxi),
                        String.format("%10f", Fix),
                        String.format("%20f", errorResult)
                    };
                    model.addRow(fila);
                    cont++;
                    if (errorResult <= error) {
                        break;
                    }
                    derivada = fx.Derivate();
                    Function f2 = new Function(derivada);
                    Fix = f2.eval(interval);
                    x2 = -((Fxi) / (Fix));
                    interval = interval + (x2);
                }
                JOptionPane.showMessageDialog(
                        null, "La raíz es: " + String.format("%10f", interval) + " y se alcanzó en " + (cont - 1) + " iteraciones",
                        "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Esa no es la raiz exacta",
                        "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en metodo Newton: " + e.getMessage());
        }
    }
}
