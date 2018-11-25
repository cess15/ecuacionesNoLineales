/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UTB.funcion;

import javax.swing.JOptionPane;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author Cess
 */
public class Function {

    DJep dj;
    ;
    private String f;

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public Function(String f) {
        dj = new DJep();
        this.f = f;
        dj.addStandardConstants();//agrega constantes estandares, pi, e, etc
        dj.addStandardFunctions();//agrega funciones estandares cos(x), sin(x)
        dj.addComplex();;//por si existe algun numero complejo
        dj.setAllowUndeclared(true);//permite variables no declarables
        dj.setAllowAssignment(true);//permite asignaciones
        dj.setImplicitMul(true);//regla de multiplicacion o para sustraccion y sumas
        dj.addStandardDiffRules();
    }

    public String Derivate() {
        String derivada = "";
        try {
            //coloca el nodo con una funcion preestablecida
            Node node = dj.parse(f);
            //deriva la funcion correcta a x
            Node diff = dj.differentiate(node, "x");
            //Simplificamos la funcion con respecto a x
            Node simp = dj.simplify(diff);
            //Convertimos el valor simplificado a un String
            derivada = dj.toString(simp);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Función Incorrecta!", "ERROR: " + e.getMessage(), 0);
        }
        return derivada;
    }

    public Double eval(Double x) throws ParseException {
        Node re = null;
        String r = "";
        dj.addVariable("x", x);
        try {
            re = dj.parse(f);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Función Incorrecta", "ERROR: " + ex.getMessage(), 0);
        }
        r = (dj.evaluate(re).toString());
        return Double.parseDouble(r);
    }
}
