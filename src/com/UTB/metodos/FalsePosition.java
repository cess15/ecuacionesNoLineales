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
        boolean root = false;
        try {
            double Fa = 0;
            double Fb = 0;
            Fa = fx.eval(intervalA);
            Fb = fx.eval(intervalB);
            if ((Fa * Fb) <= 0) {
                root = true;
            } else {
                root = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return root;
    }

    public void calcFalsePosition(JTable table, Function fx, double intervalA, double intervalB, double error, int i) {
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
                    Xk,
                    Fa,
                    Fb,
                    Fx,
                    errorResult};
                if (Fa * Fx < 0) {
                    intervalB = Xk;
                    Fb = Fx;
                } else {
                    intervalA = Xk;
                    Fa = Fx;
                }
                if (errorResult <= error) {
                    break;
                }
                model.addRow(fila);
                cont++;
            } while (cont <= i);
            JOptionPane.showMessageDialog(
                    null, "La raíz es: " + Xk + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
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
                        Xi,
                        Fa,
                        Fb,
                        Fxi,
                        errorResult};
                    if (Fxi < 0) {
                        intervalA = Xi;
                    } else {
                        intervalB = Xi;
                    }
                    model.addRow(fila);
                    cont++;
                }
                JOptionPane.showMessageDialog(
                        null, "La raíz es: " + Xi + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
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
