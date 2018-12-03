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
public class FalsePosition {

    public boolean check(Function fx, double intervalA, double intervalB) throws ParseException {
        double Fa = fx.eval(intervalA);
        double Fb = fx.eval(intervalB);
        return Fa * Fb < 0;
    }

    public void calcFalsePositionByIntervals(JTable table, Function fx, double intervalA, double intervalB, double error, int i) {
        try {
            int cont = 1;
            double Xk = 0;
            double Fa = 0;
            double Fb = 0;
            double Fx = 0;
            double errorResult = 0;
            int cont1 = 0;
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
            do {
                Fa = fx.eval(intervalA);
                Fb = fx.eval(intervalB);
                Xk = intervalB -((intervalB-intervalA)*Fb/(Fb-Fa));
                Fx = fx.eval(Xk);
                errorResult = Math.abs(intervalB - intervalA);
                Object[] fila = {
                    cont,
                    intervalA,
                    intervalB,
                    String.format("%10f", Xk),
                    String.format("%10f", Fa),
                    String.format("%10f", Fb),
                    String.format("%10f", Fx),
                    String.format("%20f", errorResult)};
                if (Fa * Fx < 0) {
                    intervalB = Xk;
                } else {
                    intervalA = Xk;
                }
                model.addRow(fila);
                cont++;
                if(Math.abs(Fx)<=error){
                    break;
                }
            } while (cont <= i);
            JOptionPane.showMessageDialog(
                    null, "La raíz es: " + String.format("%10f", Xk) + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
                    "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el metodo falsa posicion: " + e.getMessage());
        }
    }

    public void calcFalsePositionByXi(JTable table, Function fx, double intervalA, double intervalB, double error, int i) {
        try {
            int cont = 1;
            double Xk = 0;
            double Fa = 0;
            double Fb = 0;
            double Fx = 0;
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
            double Xk1 = 0;
            do {
                Fa = fx.eval(intervalA);
                Fb = fx.eval(intervalB);
                Xk = ((intervalA * Fb) - (intervalB * Fa)) / (Fb - Fa);
                Fx = fx.eval(Xk);
                errorResult = Math.abs(Xk - Xk1);
                Xk1 = Xk;
                Object[] fila = {
                    cont,
                    intervalA,
                    intervalB,
                    String.format("%10f", Xk),
                    String.format("%10f", Fa),
                    String.format("%10f", Fb),
                    String.format("%10f", Fx),
                    String.format("%20f", errorResult)};
                if (Fa * Fx < 0) {
                    intervalB = Xk;
                    Fb = Fx;
                } else {
                    intervalA = Xk;
                    Fa = Fx;
                }
                model.addRow(fila);
                cont++;
                if (errorResult <= error) {
                    break;
                }
            } while (cont <= i);
            JOptionPane.showMessageDialog(
                    null, "La raíz es: " + String.format("%10f", Xk) + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
                    "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el metodo falsa posicion: " + e.getMessage());
        }
    }

    public void calcByExactRoot(JTable table, Function fx, double intervalA, double intervalB, double error, double raiz) {
        try {
            int cont = 1;
            double Xi = 0;
            double Fa = 0;
            double Fxi = 0;
            double Fb = 0;
            double errorResult = 0;
            double eva = 0;
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
            Fa = fx.eval(intervalA);
            Fb = fx.eval(intervalB);
            Xi = ((intervalA * Fb) - (intervalB * Fa)) / (Fb - Fa);
            Fxi = fx.eval(Xi);
            errorResult = Math.abs(raiz - Xi);
            eva = fx.eval(raiz);
            if (eva == 0) {
                while (errorResult >= error) {
                    Fa = fx.eval(intervalA);
                    Fb = fx.eval(intervalB);
                    Xi = ((intervalA * Fb) - (intervalB * Fa)) / (Fb - Fa);
                    Fxi = fx.eval(Xi);
                    errorResult = Math.abs(raiz - Xi);//devuelve el valor absoluto del error
                    Object[] fila = {
                        cont,
                        intervalA,
                        intervalB,
                        String.format("%10f", Xi),
                        String.format("%10f", Fa),
                        String.format("%10f", Fb),
                        String.format("%10f", Fxi),
                        String.format("%20f", errorResult)};
                    if (Fxi < 0) {
                        intervalA = Xi;
                    } else {
                        intervalB = Xi;
                    }
                    model.addRow(fila);
                    cont++;
                }
                JOptionPane.showMessageDialog(
                        null, "La raíz es: " + String.format("%10f", Xi) + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
                        "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "La raiz no es exacta",
                        "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el metodo falsa posicion: " + e.getMessage());
        }
    }
}
