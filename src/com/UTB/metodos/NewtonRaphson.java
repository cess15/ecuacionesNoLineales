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

    //Metodo para comprobar que el resultado de la funcion evaluada por la derivada o sea cero
    public boolean check(Function f, double interval) throws ParseException {
        String derivada = f.Derivate();
        Function f2 = new Function(derivada);
        double Fix = f2.eval(interval);
        return Fix == 0;
    }

    //Metodo para calcular la raiz por xi
    public void calcNewtonRaphsonByXi(JTable table, Function fx, double interval, double error, int i) throws Exception {
        try {
            int cont = 1; //Variable para contar las iteraciones
            double Fxi = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para xi
            String derivada = null; //Variable para almacenar la derivacion de la funcion
            double Fix = 0; //Variable para almacenar el resultado de la funcion derivada para evaluar con respecto para xi
            double errorResult = 0; //Variable para almacenar el error xi-xAnt
            double x2 = 0; //Variable para almacenar la formula -((Fxi)/(Fix))
            double xAnt = 0; //Variable para almacenar el antiguo valor de xi
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "xi=a-((fF(xi))/(f'(xi)))", "f(xi)=" + fx.getF(), "f'(xi)=" + fx.Derivate(), "error=|xi-xi-1|"};
            model = new DefaultTableModel(datos, nombre_columnas) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            table.setModel(model);
            double xi = interval; //variable para almacenar a
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

    //Metodo para calcular la raiz por raiz exacta
    public void calcNewtonRaphsonByRoot(JTable table, Function fx, double interval, double error, double raiz) throws Exception {
        try {
            int cont = 1; //Variable para contar las iteraciones
            double Fxi = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para xi
            String derivada = null; //Variable para almacenar la derivacion de la funcion
            double Fix = 0; //Variable para almacenar el resultado de la funcion derivada para evaluar con respecto para xi
            double errorResult = 0; //Variable para almacenar el error raiz-xi
            double x2 = 0; //Variable para almacenar la formula -((Fxi)/(Fix))
            double eva = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para raiz
            double xAnt=0; //Variable para almacenar el antiguo valor de xi
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "xi=a-((f(xi))/(f'(xi)))", "f(xi)=" + fx.getF(), "f'(xi)=" + fx.Derivate(), "error=|xi-√x|"};
            model = new DefaultTableModel(datos, nombre_columnas) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            table.setModel(model);
            double xi=interval; //variable para almacenar a
            errorResult = Math.abs(raiz - xi);
            eva = fx.eval(raiz);
            if (eva == 0) {
                while (errorResult >= error || cont>=100) {
                    xAnt=xi;
                    Fxi = fx.eval(xi);
                    errorResult = Math.abs(raiz - xi);
                    derivada = fx.Derivate();
                    Function f2 = new Function(derivada);
                    Fix = f2.eval(xi);
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
                    if (cont == 100) {
                        JOptionPane.showMessageDialog(null, "La sucesion de aproximacion no converge a la raiz. Intente con otro punto");
                        break;
                    }
                    x2 = -((Fxi) / (Fix));
                    xi = xi + (x2);
                }
                JOptionPane.showMessageDialog(
                        null, "La raíz es: " + String.format("%10f", xAnt) + " y se alcanzó en " + (cont - 1) + " iteraciones",
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
