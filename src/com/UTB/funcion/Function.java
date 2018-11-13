/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UTB.funcion;

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
        dj.setImplicitMul(true);//regla de multiplicacion o para sustraccion y sumasif (dj.hasError()) {
        dj.addStandardDiffRules();
    }

    public String Derivate(String function) throws org.nfunk.jep.ParseException {
        DJep j = new DJep();
        String derivada = "NO hay derivada";
        j.addStandardConstants();//agrega constantes estandares, pi, e, etc
        j.addStandardFunctions();//agrega funciones estandares cos(x), sin(x)
        j.addComplex();;//por si existe algun numero complejo
        j.setAllowUndeclared(true);//permite variables no declarables
        j.setAllowAssignment(true);//permite asignaciones
        j.setImplicitMul(true);//regla de multiplicacion o para sustraccion y sumas
        Node node = j.parse(function);
        Node diff = j.differentiate(node, "x");
        Node simp = j.simplify(diff);
        derivada = j.toString(simp);
        return derivada;
    }

    public Double eval(Double x) throws ParseException, Exception {
        Node re = null;
        String val = "No se puede evaluar";
        dj.addVariable("x", x);
        try {
            re = dj.parse(f);
        } catch (Exception e) {

        }
        val = (dj.evaluate(re)).toString();
        return Double.parseDouble(val);
    }
}
