/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UTB;

import com.UTB.presentacion.Main;
import javax.swing.JFrame;

/**
 *
 * @author Cess
 */
public class App {
    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
        main.setResizable(false);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
