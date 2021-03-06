/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UTB.presentacion;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Cess
 */
public class ColorTable extends DefaultTableCellRenderer {

    //Metodo para colorear las tablas de las vistas Biseccion y Falsa Posicion
    public Component getTableCellRendererComponent(final JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        for (int i = 0; i < table.getRowCount(); i++) {
            if (row == i) {
                if (column == 3) {
                    setBackground(new Color(38, 107, 127));
                    setForeground(Color.WHITE);
                }
            } else {
                setBackground(new Color(152, 201, 245));
                setForeground(Color.BLACK);
            }
        }
        return this;
    }
}
