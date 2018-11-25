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

    public boolean check(Function f, double intervalA, double intervalB) throws ParseException {
        double Fa = f.eval(intervalA);
        double Fb = f.eval(intervalB);
        return Fa * Fb <= 0;
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
            while (cont <= i) {
                Xk = (intervalA + intervalB) / 2;
                fXk = fx.eval(Xk);
                Fa = fx.eval(intervalA);
                Fb = fx.eval(intervalB);
                errorResult = Math.abs(intervalB - intervalA);//devuelve el valor absoluto del error
                Object[] row
                        = {
                            cont,
                            intervalA,
                            intervalB,
                            String.format("%10f", Xk),
                            String.format("%10f", Fa),
                            String.format("%10f", Fb),
                            String.format("%10f", fXk),
                            String.format("%20f", errorResult)};
                if (fXk * Fa <= 0) {
                    intervalB = Xk;
                } else {
                    intervalA = Xk;
                }
                model.addRow(row);
                cont++;
                if (errorResult <= error) {
                    break;
                }
            }
            JOptionPane.showMessageDialog(
                    null, "La raíz es: " + String.format("%10f", Xk) + " \n y se alcanzó en " + (cont - 1) + " iteraciones",
                    "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el metodo biseccion: " + e.getMessage());
        }
    }

    public void calcByExactRoot(JTable table, Function fx, double intervalA, double intervalB, double error, double Raiz) {
        try {
            int cont = 1;
            double Xi = 0;
            double Fa = 0;
            double fXi = 0;
            double Fb = 0;
            double ResultadoError = 0;
            double isRoot = 0;
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
            Xi = (intervalA + intervalB) / 2;
            ResultadoError = Math.abs(Raiz - Xi);
            isRoot = fx.eval(Raiz);
            if (isRoot == 0) {
                while (ResultadoError >= error) {
                    Xi = (intervalA + intervalB) / 2;
                    Fa = fx.eval(intervalA);
                    fXi = fx.eval(Xi);
                    Fb = fx.eval(intervalB);
                    ResultadoError = Math.abs(Raiz - Xi);//devuelve el valor absoluto del error
                    Object[] fila = {
                        cont,
                        intervalA,
                        intervalB,
                        String.format("%10f", Xi),
                        String.format("%10f", Fa),
                        String.format("%10f", Fb),
                        String.format("%10f", fXi),
                        String.format("%20f", ResultadoError)
                    };
                    if (fXi < 0) {
                        intervalA = Xi;
                    } else {
                        intervalB = Xi;
                    }
                    model.addRow(fila);
                    cont++;
                }
                JOptionPane.showMessageDialog(null, "FELICIDADES SU RESPUESTA ES: " + String.format("%10f", Xi) + " \n ENCONTRADA EN " + (cont - 1) + " PASOS",
                        "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Esa no es la raiz exacta",
                        "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el metodo biseccion: " + e.getMessage());
        }
    }
}
