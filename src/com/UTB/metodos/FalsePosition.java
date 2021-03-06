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

    //Metodo para comprobar si hay una raiz aproximada para los puntos
    public boolean check(Function fx, double intervalA, double intervalB) throws ParseException {
        double Fa = fx.eval(intervalA);
        double Fb = fx.eval(intervalB);
        return Fa * Fb < 0;
    }

    //Metodo para calcular la raiz por intervalos
    public void calcFalsePositionByIntervals(JTable table, Function fx, double intervalA, double intervalB, double error, int i) {
        try {
            int cont = 1; //Variable para contar las iteraciones
            double Xk = 0; //Variable para almacenar el resultado de la formula b-((b-a)*fb/(fb-fa))
            double Fa = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para a
            double Fb = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para b
            double Fx = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para Xk 
            double errorResult = 0; //Variable para almacenar el error b-a
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "a", "b", "xi=b-((b-a)*fb/(fb-fa))", "f(a)", "f(b)", "f(xi)", "error=|b-a|"};
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
                Xk = intervalB - ((intervalB - intervalA) * Fb / (Fb - Fa));
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
                if (Math.abs(Fx) <= error) {
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

    //Metodo para calcular la raiz por xi
    public void calcFalsePositionByXi(JTable table, Function fx, double intervalA, double intervalB, double error, int i) {
        try {
            int cont = 1; //Variable para contar las iteraciones
            double Xk = 0; //Variable para almacenar el resultado de la formula b-((b-a)*fb/(fb-fa))
            double Fa = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para a
            double Fb = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para b
            double Fx = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para Xk
            double errorResult = 0; //Variable para almacenar el error Xk-Xk1
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "a", "b", "xi=((a*fb)-(b*fa))/(fb-fa)", "f(a)", "f(b)", "f(xi)", "error=|xi-xi-1|"};
            model = new DefaultTableModel(datos, nombre_columnas) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            table.setModel(model);
            double Xk1 = 0; //Variable para almacenar el antiguo valor de Xk
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

    //Metodo para calcular la raiz por raiz exacta
    public void calcByExactRoot(JTable table, Function fx, double intervalA, double intervalB, double error, double raiz) {
        try {
            int cont = 1; //Variable para contar las iteraciones
            double Xi = 0; //Variable para almacenar el resultado de la formula b-((b-a)*fb/(fb-fa))
            double Fa = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para a
            double Fxi = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para Xi
            double Fb = 0;  //Variable para almacenar el resultado de la funcion evaluada con respecto para b
            double errorResult = 0; //Variable para almacenar el error raiz-Xi
            double eva = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para raiz
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "a", "b", "xi=((a*fb)-(b*fa))/(fb-fa)", "f(a)", "f(b)", "f(xi)", "error=|xi-√x|"};
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
            errorResult = Math.abs(raiz - Xi);
            eva = fx.eval(raiz);
            if (eva == 0) {
                while (errorResult >= error || cont >= 100) {
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
                    if (cont == 100) {
                        JOptionPane.showMessageDialog(null, "La sucesion de puntos no se aproxima a la raiz. Intente con otros puntos");
                        break;
                    }
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
