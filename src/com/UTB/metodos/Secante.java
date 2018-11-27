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
public class Secante {

    public boolean check(Function f, double intervalA, double intervalB) throws ParseException {
        double Fa = f.eval(intervalA);
        double Fb = f.eval(intervalB);
        return Fa * Fb < 0;
    }

    public void calcSecant(JTable table, Function fx, double intervalA, double intervalB, double error, int i) {
        try {
            int cont = 1;
            double Fx0 = 0;
            double Fx1 = 0;
            double errorResult = 0;
            double aux = 0;
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "xi", "yi", "Error"};
            model = new DefaultTableModel(datos, nombre_columnas) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            table.setModel(model);
            do {
                Fx0 = fx.eval(intervalA);
                errorResult = Math.abs(intervalA - intervalB);
                Object[] fila = {
                    cont,
                    intervalA,
                    String.format("%10f", Fx0),
                    String.format("%20f", errorResult)
                };
                model.addRow(fila);
                Fx1 = fx.eval(intervalB);
                aux = intervalB;
                intervalB = intervalB - (((intervalB - intervalA) / (Fx1 - Fx0)) * Fx1);
                intervalA = aux;
                cont++;
                if (errorResult <= error) {
                    break;
                }
            } while (cont <= i);
            JOptionPane.showMessageDialog(
                    null, "La raíz es: " + String.format("%10f", Fx0) + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
                    "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el metodo biseccion: " + e.getMessage());
        }
    }

    public void calcSecantByRoot(JTable table, Function fx, double intervalA, double intervalB, double error, double raiz) {
        try {
            int cont = 1;
            double Fx0 = 0;
            double Fx1 = 0;
            double errorResult = 0;
            double aux = 0;
            double eva = 0;
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "xi", "yi", "Error"};
            model = new DefaultTableModel(datos, nombre_columnas) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }
            };
            table.setModel(model);
            Fx0 = fx.eval(intervalA);
            errorResult = Math.abs(intervalA - intervalB);
            eva = fx.eval(raiz);
            if (eva == 0) {
                while (errorResult >= error) {
                    Fx0 = fx.eval(intervalA);
                    errorResult = Math.abs(intervalA - intervalB);
                    Object[] fila = {
                        cont,
                        intervalA,
                        String.format("%10f", Fx0),
                        String.format("%20f", errorResult)
                    };
                    model.addRow(fila);
                    Fx1 = fx.eval(intervalB);
                    aux = intervalB;
                    intervalB = intervalB - (((intervalB - intervalA) / (Fx1 - Fx0)) * Fx1);
                    intervalA = aux;
                    cont++;
                }
                JOptionPane.showMessageDialog(
                        null, "La raíz es: " + String.format("%10f", Fx0) + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
                        "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "La raiz no es exacta",
                        "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el metodo secante: " + e.getMessage());
        }
    }
}