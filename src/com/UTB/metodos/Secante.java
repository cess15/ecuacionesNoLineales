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

/**
 *
 * @author Cess
 */
public class Secante {

    //Metodo para calcular la raiz por xi
    public void calcSecantByXi(JTable table, Function fx, double intervalA, double intervalB, double error, int i) {
        try {
            int cont = 1; //Variable para contar las iteraciones
            double Fx0 = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para a
            double Fx1 = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para b
            double errorResult = 0; //Variable para almacenar el error a-b
            double aux = 0; //Variable auxiliar para agilizar el proceso
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "xi", "yi", "error=|xi-xi-1|"};
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
                    null, "La raíz se alcanzó en " + (cont - 1) + " iteraciones",
                    "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el metodo secante: " + e.getMessage());
        }
    }

    //Metodo para calcular la raiz por raiz exacta
    public void calcSecantByRoot(JTable table, Function fx, double intervalA, double intervalB, double error, double raiz) {
        try {
            int cont = 1; //Variable para contar las iteraciones
            double Fx0 = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para a
            double Fx1 = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para b
            double errorResult = 0; //Variable para almacenar el error raiz-a
            double aux = 0; //Variable auxiliar para agilizar el proceso
            double eva = 0; //Variable para almacenar el resultado de la funcion evaluada con respecto para raiz
            DefaultTableModel model;
            String[][] datos = {};
            String[] nombre_columnas = {"i", "xi", "yi", "error=|xi-√x|"};
            model = new DefaultTableModel(datos, nombre_columnas) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }
            };
            table.setModel(model);
            errorResult = Math.abs(raiz - intervalA);
            eva = fx.eval(raiz);
            if (eva == 0) {
                while (errorResult >= error || cont>=100) {
                    Fx0 = fx.eval(intervalA);
                    errorResult = Math.abs(raiz - intervalA);
                    Object[] fila = {
                        cont,
                        intervalA,
                        String.format("%10f", Fx0),
                        String.format("%20f", errorResult)
                    };
                    model.addRow(fila);
                    cont++;
                    if (errorResult <= error) {
                        break;
                    }
                    if(cont==100){
                        if (cont == 100) {
                        JOptionPane.showMessageDialog(null, "La sucesion de puntos no se aproxima a la raiz. Intente con otros puntos");
                        break;
                    }
                    }
                    Fx1 = fx.eval(intervalB);
                    aux = intervalB;
                    intervalB = intervalB - (((intervalB - intervalA) / (Fx1 - Fx0)) * Fx1);
                    intervalA = aux;
                }
                JOptionPane.showMessageDialog(
                        null, "La raíz es: " + intervalA + " y se alcanzó en " + (cont - 1) + " iteraciones",
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
