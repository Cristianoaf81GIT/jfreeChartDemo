/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.profcristianoaf81.exemplojfreechart;
import javax.swing.*;

/**
 *
 * @author cristianoaf81
 */
public class principal{
   
    
    public static void main(String[] args){
      
     SwingUtilities.invokeLater(() -> {
         JanelaGrafico_jfreeChart janela = new JanelaGrafico_jfreeChart();
         janela.setVisible(true);
     });
     
    }
    
    
}
