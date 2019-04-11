/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.profcristianoaf81.exemplojfreechart.linha;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Linha extends JFrame {
    private JFreeChart chart;
    private DefaultCategoryDataset dts;
    private File pct_chart;
    
    private DefaultCategoryDataset gerarSetDeDados(){
        dts = new DefaultCategoryDataset();
        dts.addValue(15, "Escolas", "1970");
        dts.addValue(25, "Escolas", "1980");
        dts.addValue(35, "Escolas", "1990");
        dts.addValue(45, "Escolas", "2000");
        dts.addValue(130,"Escolas", "2010");
        dts.addValue(170,"Escolas", "2017");
        return dts;
    }
    
    public JFreeChart criaGraficoLinhas(){
        chart = ChartFactory.createLineChart("Número de Escolas durante as Décadas" //titulo
                , "Anos" //eixo x
                , "Nº de Escolas"//eixo y
                , gerarSetDeDados() //dados
                , PlotOrientation.VERTICAL //orientação
                , true //legenda
                , true //dicas de tela
                , false); //urls
        
        CategoryPlot plotagem = chart.getCategoryPlot();
        plotagem.setBackgroundPaint(java.awt.Color.WHITE);
        plotagem.setRangeGridlinesVisible(true);
        plotagem.setRangeGridlinePaint(java.awt.Color.DARK_GRAY);
        plotagem.setOutlinePaint(java.awt.Color.darkGray);
        plotagem.setWeight(4);
        
        for(int i = 0; i <= 5;i++){
            plotagem.getRenderer().setSeriesItemLabelGenerator(i
                    ,new StandardCategoryItemLabelGenerator("{2} {0}"
                            , NumberFormat.getNumberInstance(Locale.getDefault())) );
            plotagem.getRenderer().setSeriesItemLabelsVisible(i, true);
            plotagem.getRenderer().setSeriesPaint(i, java.awt.Color.BLUE);
        }
        
        return chart;
        
    }
    
    public void gerarGraficoLinhasPNG(){
      
       try{
        String path = System.getProperty("user.home")+"/Desktop/linhas.png";
        pct_chart = new File(path);
        int w = 500;
        int h = 455;
        ChartUtilities.saveChartAsPNG(pct_chart, criaGraficoLinhas(), w, h);
        JOptionPane.showMessageDialog(null, "Arquivo Salvo com sucesso !!!"
                +"\n local = "+pct_chart.getAbsolutePath(),"Aviso",JOptionPane.INFORMATION_MESSAGE);
       }catch(IOException io){
           JOptionPane.showMessageDialog(null, io.getMessage());
       }
      //return pct_chart;
    }
}
